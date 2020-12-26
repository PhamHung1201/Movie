package com.hungpham.ui_image.data

import com.hungpham.data.internal.movie.ImageOfMovieData
import com.hungpham.ui_image.Image


class ImageFactory {

    fun createImages(data: ImageOfMovieData): List<Image> {
        return data.posters.sortedByDescending { it.voteAverage }
            .map {
                Image(
                    "1",
                    it.thumbnail,
                    it.medium,
                    it.large,
                    it.aspectRatio,
                    it.height,
                    it.width,
                    it.voteAverage,
                    it.voteCount
                )
            }
    }
}