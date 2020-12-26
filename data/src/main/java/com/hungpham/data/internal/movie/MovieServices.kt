package com.hungpham.data.internal.movie

import com.hungpham.data.internal.movie.response.*
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import retrofit2.http.Path

interface MovieServices {

    @GET("discover/movie")
    suspend fun getDiscoverMovies(@QueryMap filters: Map<String, String>): DiscoverMovieResponse

    @GET("trending/movie/day")
    suspend fun getTrendingMovies(@Query("page") page: Int = 1): TrendingMoviesResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("page") page: Int = 1): UpcomingMoviesResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int = 1): PopularMoviesResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("page") page: Int = 1): PopularMoviesResponse

    @GET("genre/movie/list")
    suspend fun getGenres(): GenresResponse

    @GET("movie/{id}")
    suspend fun getMovieDetails(@Path("id") id: Long): MovieDetailsResponse

    @GET("movie/{id}/videos")
    suspend fun getVideoOfMovieDetails(@Path("id") id: Long): VideoOfAMovieResponse

    @GET("movie/{id}/images")
    suspend fun getImageOfMovieDetails(@Path("id") id: Long): ImageOfMovieResponse

    @GET("person/popular")
    suspend fun getPopularActors(@Query("page") page: Int = 1): PopularActorResponse

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("page") page: Int = 1): TvShowResponse

    @GET("discover/tv")
    suspend fun getDiscoverTvShows(@QueryMap filters: Map<String, String>): TvShowResponse
}