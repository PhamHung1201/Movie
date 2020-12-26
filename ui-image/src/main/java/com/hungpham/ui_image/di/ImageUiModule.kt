package com.hungpham.ui_image.di

import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardKey
import com.hungpham.card_kit.CardType
import com.hungpham.data.DataRepository
import com.hungpham.image_support.ImageDownloader
import com.hungpham.ui_image.ImageAdapter
import com.hungpham.ui_image.ImageCard
import com.hungpham.ui_image.data.ImageDataSource
import com.hungpham.ui_image.data.ImageFactory
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet


@Module
object ImageUiModule {

    @Provides
    @IntoSet
    fun provideImageCard(imageDownloader: ImageDownloader): Card {
        return ImageCard(Lazy { ImageAdapter(imageDownloader) })
    }

    @Provides
    @IntoMap
    @CardKey(CardType.IMAGE)
    fun provideImageDataSource(dataRepository: DataRepository): CardDataProvider {
        return ImageDataSource(dataRepository, ImageFactory())
    }
}