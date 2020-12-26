package com.hungpham.data

import com.hungpham.data.internal.movie.*
import com.hungpham.model.GenreData

interface DataRepository {

    suspend fun getDiscoverMovie(filters: Map<String, String>): List<MovieData>

    suspend fun getTrendingMovie(): List<MovieData>

    suspend fun getMovieDetails(movieId: Long): MovieDetailsData

    suspend fun getVideoOfAMovie(movieId: Long): VideoOfMovieData

    suspend fun getImageOfAMovie(movieId: Long): ImageOfMovieData

    suspend fun getActors(): List<ActorData>

    suspend fun getPopularTvShows(): List<TvShowData>

    suspend fun getDiscoverTvShowBy(filters: Map<String, String>): List<TvShowData>

    suspend fun getGenres(): List<GenreData>

    suspend fun saveGenre(genres: List<GenreData>)
}