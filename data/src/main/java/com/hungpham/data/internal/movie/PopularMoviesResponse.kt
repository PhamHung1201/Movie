package com.hungpham.data.internal.movie

import com.google.gson.annotations.SerializedName

data class PopularMoviesResponse(
    private val page: Int?,
    @SerializedName("total_results") private val totalPages: Int?,
    @SerializedName("results") private val movies: List<Movie>?) {

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