package com.hungpham.movie.movies.di

import com.hungpham.movie_support.MovieProvider
import com.hungpham.movie_support.MovieServices
import com.hungpham.movie_support.internal.di.MoviesSupportGraph
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MovieViewModelModule {

    @Provides
    fun providesMoviesSupportGraph(retrofit: Retrofit): MoviesSupportGraph {
        return MoviesSupportGraph(retrofit)
    }

    @Provides
    fun providesMoviesService(graph: MoviesSupportGraph): MovieServices {
        return graph.getMoviesService()
    }

    @Provides
    fun provideMovieProvider(graph: MoviesSupportGraph): MovieProvider {
        return graph.getMovieProvider()
    }
}