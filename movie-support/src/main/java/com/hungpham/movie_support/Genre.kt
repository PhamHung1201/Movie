package com.hungpham.movie_support


data class Genre(
    private val id: Int?,
    private val name: String?
) {
    fun getId(): Int {
        return id ?: -1
    }

    fun getName(): String {
        return name ?: ""
    }
}