package com.hungpham.movie_support.internal.response

import com.google.gson.annotations.SerializedName
import com.hungpham.movie_support.internal.Movie

data class DiscoverMovieResponse(
    private val page: Int?,
    @SerializedName("total_results") private val totalPages: Int?,
    @SerializedName("results") private val movies: List<Movie>?){

    fun getPage(): Int {
        return page ?: 1
    }

    fun getTotalPages(): Int {
        return totalPages ?: 1
    }

    fun getMovies(): List<Movie> {
        return movies ?: emptyList()
    }
}