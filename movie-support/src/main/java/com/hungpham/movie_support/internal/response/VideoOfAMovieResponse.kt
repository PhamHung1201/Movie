package com.hungpham.movie_support.internal.response

data class VideoOfAMovieResponse(
    private val id: Int?,
    private val results: List<VideoResponse>?) {

    fun getId(): Int{
        return id ?: 0
    }

    fun getResults(): List<VideoResponse>{
        return results ?: emptyList()
    }

    data class VideoResponse(
        private val id: String?,
        private val key: String?,
        private val name: String?,
        private val site: String?,
        private val size: Int?,
        private val type: String?) {

        fun getId(): String{
            return id ?: ""
        }

        fun getKey(): String{
            return key ?: ""
        }

        fun getName(): String{
            return name ?: ""
        }

        fun getSite(): String{
            return site ?: ""
        }

        fun getSize(): Int{
            return size ?: 0
        }

        fun getType(): String{
            return type ?: ""
        }

    }
}