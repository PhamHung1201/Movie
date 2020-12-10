package com.hungpham.movie_support

import com.hungpham.movie_support.internal.PopularMoviesResponse
import com.hungpham.movie_support.internal.TrendingMoviesResponse
import com.hungpham.movie_support.internal.UpcomingMoviesResponse
import com.hungpham.movie_support.internal.response.*
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieServices {

    @GET("discover/movie")
    fun getDiscoverMovies(@Query("page") page: Int = 1): Single<DiscoverMovieResponse>

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

}