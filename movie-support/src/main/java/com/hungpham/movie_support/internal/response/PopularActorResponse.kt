package com.hungpham.movie_support.internal.response

import com.google.gson.annotations.SerializedName

data class PopularActorResponse(
    private val page: Int?,
    @SerializedName("total_results") private val totalPages: Int?,
    @SerializedName("results") private val actors: List<Actor>?
) {

    fun getPage(): Int {
        return page ?: 1
    }

    fun getTotalPages(): Int {
        return totalPages ?: 1
    }

    fun getActors(): List<Actor> {
        return actors ?: emptyList()
    }

    data class Actor(
        @SerializedName("id") private val id: Int?,
        @SerializedName("profile_path") private val profilePath: String?,
        @SerializedName("name") private val name: String?,
        @SerializedName("popularity") private val popularity: Float?
    ) {
        fun getId(): Long {
            return id?.toLong() ?: -1
        }

        fun getProfilePath(): String {
            return profilePath.orEmpty()
        }

        fun getName(): String {
            return name.orEmpty()
        }

        fun getPopularity(): Int {
            return popularity?.toInt() ?: 0
        }

    }
}