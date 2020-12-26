package com.hungpham.data.internal.movie.response

import com.hungpham.data.internal.movie.Movie


class BaseMovieResponse (private val movies: List<Movie>?){
    fun getMovies(): List<Movie> {
        return movies ?: emptyList()
    }
}