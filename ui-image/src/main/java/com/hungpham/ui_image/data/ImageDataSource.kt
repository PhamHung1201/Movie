package com.hungpham.ui_image.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.data.DataRepository
import com.hungpham.ui_image.ImageCardItem

class ImageDataSource(
    private val dataRepository: DataRepository,
    private val factory: ImageFactory
) : CardDataProvider {

    override suspend fun dataSource(): CardItem {
        val imageOfAMovie = dataRepository.getImageOfAMovie(1)

        return ImageCardItem(factory.createImages(imageOfAMovie))
    }
}