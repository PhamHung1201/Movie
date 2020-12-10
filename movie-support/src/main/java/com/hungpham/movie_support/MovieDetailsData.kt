package com.hungpham.movie_support

data class MovieDetailsData(
    val id: Long,
    val title: String,
    val overview: String,
    val poster: ImageData,
    val backdrop: ImageData,
    val runtime: Int,
    val originalLanguage: String,
    val budget: Long,
    val voteAverage: Float,
    val voteCount: Int,
    val revenue: Long
)