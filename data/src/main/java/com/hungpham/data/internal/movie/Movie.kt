package com.hungpham.data.internal.movie

import com.google.gson.annotations.SerializedName


data class Movie(
    @SerializedName("vote_count") private val voteCount: Int?,
    private val id: Long?,
    private val video: Boolean?,
    @SerializedName("vote_average") private val voteAverage: Float?,
    private val title: String?,
    @SerializedName("poster_path") private val posterPath: String?,
    @SerializedName("backdrop_path") private val backdropPath: String?,
    private val popularity: Float?,
    private val adult: Boolean?,
    private val overview: String?,
    @SerializedName("release_date") private val releaseDate: String?
) {

    fun getVoteCount(): Int {
        return voteCount ?: 1
    }

    fun getId(): Long {
        return id ?: 0
    }

    fun getVoteAverage(): Float {
        return voteAverage ?: 0.0F
    }

    fun getTitle(): String {
        return title ?: ""
    }

    fun getPosterPath(): String {
        return posterPath ?: ""
    }

    fun getBackdropPath(): String {
        return backdropPath ?: ""
    }

    fun isAdult(): Boolean {
        return adult ?: false
    }

    fun getOverview(): String {
        return overview ?: ""
    }

    fun getReleaseDate(): String {
        return releaseDate ?: ""
    }

    fun getPopularity(): Float {
        return popularity ?: 0.0f
    }
}