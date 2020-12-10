package com.hungpham.movie_support.internal

import com.hungpham.movie_support.ImageData
import com.hungpham.movie_support.image.ImageSizeProvider

/**
 * Created by hung.pham on 10/11/20.
 */
class ImageDataFactory {

    fun create(path: String): ImageData {
        return ImageData(
            "${ImageSizeProvider.BASE}${ImageSizeProvider.W92}/${path}",
            "${ImageSizeProvider.BASE}${ImageSizeProvider.W342}/${path}",
            "${ImageSizeProvider.BASE}${ImageSizeProvider.W780}/${path}",
        )
    }
}