package com.hungpham.movie_support.internal.di

import com.hungpham.movie_support.MovieProvider
import com.hungpham.movie_support.MovieServices
import com.hungpham.movie_support.internal.ImageDataFactory
import com.hungpham.movie_support.internal.MovieProviderImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MoviesSupportModule(private val retrofit: Retrofit) {

    @Provides
    fun providesMoviesService(): MovieServices {
        return retrofit.create(MovieServices::class.java)
    }

    @Provides
    fun provideMovieProvider(movieServices: MovieServices): MovieProvider {
        return MovieProviderImpl(movieServices, ImageDataFactory())
    }
}