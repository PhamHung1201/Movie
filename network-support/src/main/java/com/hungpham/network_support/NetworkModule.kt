package com.hungpham.network_support

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hungpham.network_support.calladapters.HttpExceptionCallAdapterFactory
import com.hungpham.network_support.calladapters.NetworkErrorCallAdapterFactory
import com.hungpham.network_support.calladapters.ObserveOnSchedulerCallAdapterFactory
import com.hungpham.network_support.configurations.NetworkConfiguration
import com.hungpham.network_support.configurations.SchedulerConfiguration
import com.hungpham.network_support.interceptors.TMDbRequestInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule(private val networkConfiguration: NetworkConfiguration,
                    private val schedulerConfiguration: SchedulerConfiguration) {
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(networkConfiguration.getHost())
            .addCallAdapterFactory(ObserveOnSchedulerCallAdapterFactory.create(schedulerConfiguration.mainScheduler()))
            .addCallAdapterFactory(NetworkErrorCallAdapterFactory.create(gson))
            .addCallAdapterFactory(HttpExceptionCallAdapterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(schedulerConfiguration.ioScheduler()))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor,
                             tMDbRequestInterceptor: TMDbRequestInterceptor,
                             cache: Cache): OkHttpClient {
        val builder = OkHttpClient.Builder()

        return builder
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(tMDbRequestInterceptor)
            .connectTimeout(networkConfiguration.getTimeoutSeconds(), TimeUnit.SECONDS)
            .readTimeout(networkConfiguration.getTimeoutSeconds(), TimeUnit.SECONDS)
            .writeTimeout(networkConfiguration.getTimeoutSeconds(), TimeUnit.SECONDS)
            .followRedirects(false)
            .cache(cache)
            .build()
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().setExclusionStrategies(object : ExclusionStrategy {
            override fun shouldSkipClass(clazz: Class<*>?): Boolean {
                return false
            }

            override fun shouldSkipField(f: FieldAttributes?): Boolean {
                return false
            }
        }).setLenient().create()
    }

    @Provides
    fun provideLastFmRequestInterceptor(): TMDbRequestInterceptor {
        return TMDbRequestInterceptor(networkConfiguration.getApiKey())
    }

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideCache(): Cache {
        return Cache(networkConfiguration.getCacheDir(), networkConfiguration.getCacheSize())
    }
}
