package com.hungpham.data.internal.movie

import com.hungpham.data.internal.image.ImageSizeProvider

class ImageDataFactory {

    fun create(path: String): ImageData {
        return ImageData(
            "${ImageSizeProvider.BASE}${ImageSizeProvider.W92}/${path}",
            "${ImageSizeProvider.BASE}${ImageSizeProvider.W342}/${path}",
            "${ImageSizeProvider.BASE}${ImageSizeProvider.W780}/${path}",
        )
    }
}