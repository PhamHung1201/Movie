package com.hungpham.movie_support

import io.reactivex.Single

interface MovieProvider {

    fun getDiscoverMovie(filters: Map<String, String>): Single<List<MovieData>>

    fun getTrendingMovie(): Single<List<MovieData>>

    fun getMovieDetails(movieId: Long): Single<MovieDetailsData>

    fun getVideoOfAMovie(movieId: Long): Single<VideoOfMovieData>

    fun getImageOfAMovie(movieId: Long): Single<ImageOfMovieData>

    fun getActors(): Single<List<ActorData>>

    fun getPopularTvShows(): Single<List<TvShowData>>

    fun getDiscoverTvShowBy(filters: Map<String, String>): Single<List<TvShowData>>
}