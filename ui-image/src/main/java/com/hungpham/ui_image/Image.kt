package com.hungpham.ui_image

data class Image(
    val id: String,
    val thumbnail: String,
    val medium: String,
    val large: String,
    val aspectRatio: Float = 1F,
    val height: Int = 0,
    val width: Int = 0,
    val voteAverage: Float = 0F,
    val voteCount: Int = 0
)