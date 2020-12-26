package com.hungpham.data.internal.movie.response

import com.google.gson.annotations.SerializedName
import com.hungpham.model.GenreData

data class MovieDetailsResponse(
    private val id: Long? = null,
    private val adult: Boolean? = null,
    @SerializedName("backdrop_path") private val backdropPath: String? = null,
    private val budget: Long? = null,
    private val genreData: List<GenreData>? = null,
    @SerializedName("homepage") private val homePage: String? = null,
    @SerializedName("original_language") private val originalLanguage: String? = null,
    @SerializedName("original_title") private val originalTitle: String? = null,
    private val title: String? = null,
    private val overview: String? = null,
    private val popularity: Float? = null,
    @SerializedName("poster_path") private val posterPath: String? = null,
    @SerializedName("production_companies") private val productionCompanies: List<Company>? = null,
    @SerializedName("production_countries") private val productionCountries: List<Country>? = null,
    @SerializedName("release_date") private val releaseDate: String? = null,
    private val revenue: Long? = null,
    private val runtime: Int? = null,
    private val status: String? = null,
    @SerializedName("tagline") private val tagLine: String? = null,
    private val video: Boolean? = null,
    @SerializedName("vote_average") private val voteAverage: Float? = null,
    @SerializedName("vote_count") private val voteCount: Int? = null) {
    fun getId(): Long {
        return id ?: 0L
    }

    fun isRequireAdult(): Boolean {
        return adult ?: false
    }


    fun getBackdropPath(): String {
        return backdropPath ?: ""
    }

    fun getBudget(): Long {
        return budget ?: 0
    }

    fun getGenres(): List<GenreData> {
        return genreData ?: emptyList()
    }


    fun getHomePage(): String {
        return homePage ?: ""
    }

    fun getOriginalLanguage(): String {
        return originalLanguage ?: ""
    }

    fun getOriginalTitle(): String {
        return originalTitle ?: ""
    }

    fun getTitle(): String? {
        return title ?: ""
    }

    fun getOverview(): String {
        return overview ?: ""
    }

    fun getPopularity(): Float {
        return popularity ?: 0.0F
    }

    fun getPosterPath(): String {
        return posterPath ?: ""
    }

    fun getProductionCompanies(): List<Company>? {
        return productionCompanies ?: emptyList()
    }

    fun getProductionCountries(): List<Country>? {
        return productionCountries ?: emptyList()
    }

    fun getReleaseDate(): String? {
        return releaseDate ?: ""
    }

    fun getRevenue(): Long {
        return revenue ?: 0
    }

    fun getRuntime(): Int {
        return runtime ?: 0
    }

    fun getStatus(): String {
        return status ?: ""
    }

    fun getTagLine(): String {
        return tagLine ?: ""
    }

    fun hasVideo(): Boolean {
        return video ?: false
    }

    fun getVoteAverage(): Float {
        return voteAverage ?: 0.0f
    }

    fun getVoteCount(): Int {
        return voteCount ?: 0
    }

    data class Company(
        private val id: Int?,
        @SerializedName("logo_path") private val logoPath: String?,
        private val name: String?,
        @SerializedName("origin_country") private val originCountry: String?) {
        fun getId(): Int {
            return id ?: 0
        }

        fun getLogoPath(): String {
            return logoPath ?: ""
        }

        fun getOriginCountry(): String {
            return originCountry ?: ""
        }
    }

    data class Country(
        @SerializedName("iso_3166_1") private val id: String?,
        private val name: String?) {
        fun getId(): String {
            return id ?: ""
        }

        fun getName(): String {
            return name ?: ""
        }
    }
}