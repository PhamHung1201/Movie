package com.hungpham.movie_support.internal.response

import com.hungpham.movie_support.Genre

data class GenresResponse(private val genres: List<Genre>?) {

    fun getGenres(): List<Genre> {
        return genres ?: emptyList()
    }
}