package com.hungpham.movie_support.internal.di

import com.hungpham.movie_support.MovieProvider
import com.hungpham.movie_support.MovieServices
import retrofit2.Retrofit

class MoviesSupportGraph(private val retrofit: Retrofit) {
    private val component: MoviesSupportComponent by lazy {
        DaggerMoviesSupportComponent.builder()
            .moviesSupportModule(MoviesSupportModule(retrofit))
            .build()
    }

    fun getMoviesService(): MovieServices {
        return component.moviesService()
    }

    fun getMovieProvider(): MovieProvider {
        return component.movieProvider()
    }
}