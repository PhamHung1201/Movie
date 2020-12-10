package com.hungpham.network_support.calladapters;

import com.google.gson.Gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.hungpham.network_support.ExceptionModel;
import com.hungpham.network_support.NetException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.HttpException;
import retrofit2.Retrofit;

@Singleton
public class NetworkErrorCallAdapterFactory extends CallAdapter.Factory {

    public static NetworkErrorCallAdapterFactory create(Gson gson) {
        return new NetworkErrorCallAdapterFactory(gson);
    }

    private final Gson gson;

    @Inject
    public NetworkErrorCallAdapterFactory(Gson gson) {
        this.gson = gson;
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        CallAdapter<?, ?> nextCallAdapter = retrofit.nextCallAdapter(this, returnType, annotations);

        if (getRawType(returnType).equals(Observable.class)) {
            return new ObservableAdapter(
                    (CallAdapter<Object, Observable<Object>>) nextCallAdapter, gson);
        }

        return null;
    }

    private static class ObservableAdapter implements
            CallAdapter<Object, Observable<Object>> {

        private final CallAdapter<Object, Observable<Object>> nextAdapter;
        private final Gson gson;

        public ObservableAdapter(CallAdapter<Object, Observable<Object>> nextAdapter,
                                 Gson gson) {
            this.nextAdapter = nextAdapter;
            this.gson = gson;
        }

        @Override
        public Type responseType() {
            return nextAdapter.responseType();
        }

        @Override
        public Observable<Object> adapt(Call<Object> call) {
            return nextAdapter.adapt(call).onErrorResumeNext(new Function<Throwable, ObservableSource<?>>() {
                @Override
                public ObservableSource<?> apply(Throwable throwable) throws Exception {
                    if (throwable instanceof HttpException) {
                        HttpException httpException = (HttpException) throwable;
                        if (httpException.code() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                            ExceptionModel exceptionModel = gson
                                    .fromJson(httpException.response().errorBody().string(),
                                            ExceptionModel.class);
                            return Observable.error(new NetException(exceptionModel));
                        }
                    }
                    return Observable.error(throwable);
                }
            });
        }
    }
}
