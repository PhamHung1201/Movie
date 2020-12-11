package com.hungpham.movie_support.internal.response

import com.google.gson.annotations.SerializedName


class TvShowResponse(
    private val page: Int?,
    @SerializedName("total_results") private val totalPages: Int?,
    @SerializedName("results") private val tvShows: List<TvShow>?
) {

    fun getPage(): Int {
        return page ?: 1
    }

    fun getTotalPages(): Int {
        return totalPages ?: 1
    }

    fun getTvShows(): List<TvShow> {
        return tvShows ?: emptyList()
    }

    data class TvShow(
        @SerializedName("id") private val id: Int?,
        @SerializedName("poster_path") private val posterPath: String?,
        @SerializedName("name") private val name: String?,
        @SerializedName("popularity") private val popularity: Float?
    ) {
        fun getId(): Long {
            return id?.toLong() ?: -1
        }

        fun getPosterPath(): String {
            return posterPath.orEmpty()
        }

        fun getName(): String {
            return name.orEmpty()
        }

        fun getPopularity(): Int {
            return popularity?.toInt() ?: 0
        }
    }
}