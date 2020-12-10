package com.hungpham.movie_support.internal.response

import com.hungpham.movie_support.internal.Movie

class BaseMovieResponse (private val movies: List<Movie>?){
    fun getMovies(): List<Movie> {
        return movies ?: emptyList()
    }
}