package com.hungpham.data.internal.movie

data class MovieData(
    val id: Long,
    val name: String,
    val description: String,
    val rating: Float,
    val voteCount: Int,
    val releaseDate: MovieDateTime,
    val poster: ImageData,
    val background: ImageData
)