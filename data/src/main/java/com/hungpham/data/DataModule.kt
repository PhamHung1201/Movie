package com.hungpham.data

import android.content.Context
import com.hungpham.data.internal.AppDatabase
import com.hungpham.data.internal.DataRepositoryImpl
import com.hungpham.data.internal.movie.ImageDataFactory
import com.hungpham.data.internal.movie.MovieServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(movieServices: MovieServices, database: AppDatabase): DataRepository {
        return DataRepositoryImpl(movieServices, database, ImageDataFactory())
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.create(context)
    }

    @Provides
    fun providesMoviesService(retrofit: Retrofit): MovieServices {
        return retrofit.create(MovieServices::class.java)
    }

}