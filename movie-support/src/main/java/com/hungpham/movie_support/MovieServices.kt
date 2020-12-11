package com.hungpham.movie_support

import com.hungpham.movie_support.internal.PopularMoviesResponse
import com.hungpham.movie_support.internal.TrendingMoviesResponse
import com.hungpham.movie_support.internal.UpcomingMoviesResponse
import com.hungpham.movie_support.internal.response.*
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface MovieServices {

    @GET("discover/movie")
    fun getDiscoverMovies(@QueryMap filters: Map<String, String>): Single<DiscoverMovieResponse>

    @GET("trending/movie/day")
    fun getTrendingMovies(@Query("page") page: Int = 1): Single<TrendingMoviesResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(@Query("page") page: Int = 1): Observable<UpcomingMoviesResponse>

    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page: Int = 1): Observable<PopularMoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("page") page: Int = 1): Observable<PopularMoviesResponse>

    @GET("genre/movie/list")
    fun getGenres(): Observable<GenresResponse>

    @GET("movie/{id}")
    fun getMovieDetails(@Path("id") id: Long): Single<MovieDetailsResponse>

    @GET("movie/{id}/videos")
    fun getVideoOfMovieDetails(@Path("id") id: Long): Single<VideoOfAMovieResponse>

    @GET("movie/{id}/images")
    fun getImageOfMovieDetails(@Path("id") id: Long): Single<ImageOfMovieResponse>

    @GET("person/popular")
    fun getPopularActors(@Query("page") page: Int = 1): Single<PopularActorResponse>

    @GET("tv/popular")
    fun getPopularTvShows(@Query("page") page: Int = 1): Single<TvShowResponse>

    @GET("discover/tv")
    fun getDiscoverTvShows(@QueryMap filters: Map<String, String>): Single<TvShowResponse>
}