package com.hungpham.data.internal.movie.response

import com.google.gson.annotations.SerializedName
import com.hungpham.model.GenreData

data class GenresResponse(@SerializedName("genres") private val genreData: List<GenreData>?) {

    fun getGenres(): List<GenreData> {
        return genreData ?: emptyList()
    }
}