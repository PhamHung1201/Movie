package com.hungpham.data.internal.movie.response

import com.google.gson.annotations.SerializedName

data class ImageOfMovieResponse(val posters: List<Poster>, val backdrops: List<Backdrop>) {

    data class Poster(
        @SerializedName("aspect_ratio") val aspectRatio: Float,
        @SerializedName("file_path") val filePath: String,
        @SerializedName("height") val height: Int,
        @SerializedName("width") val width: Int,
        @SerializedName("iso_639_1") val isoCode: String,
        @SerializedName("vote_average") val voteAverage: Float,
        @SerializedName("vote_count") val voteCount: Int
    )

    data class Backdrop(
        @SerializedName("aspect_ratio") val aspectRatio: Float,
        @SerializedName("file_path") val filePath: String,
        @SerializedName("height") val height: Int,
        @SerializedName("width") val width: Int,
        @SerializedName("iso_639_1") val isoCode: String,
        @SerializedName("vote_average") val voteAverage: Float,
        @SerializedName("vote_count") val voteCount: Int
    )

}