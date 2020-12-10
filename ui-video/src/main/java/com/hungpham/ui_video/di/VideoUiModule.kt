package com.hungpham.ui_video.di

import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardKey
import com.hungpham.card_kit.CardType
import com.hungpham.image_support.ImageDownloader
import com.hungpham.movie_support.MovieProvider
import com.hungpham.ui_video.VideoAdapter
import com.hungpham.ui_video.VideoCard
import com.hungpham.ui_video.data.VideoDataSource
import com.hungpham.ui_video.data.VideoFactory
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet


@Module
object VideoUiModule {

    @Provides
    @IntoSet
    fun provideVideoCard(imageDownloader: ImageDownloader): Card {
        return VideoCard(Lazy { VideoAdapter(imageDownloader) })
    }

    @Provides
    @IntoMap
    @CardKey(CardType.VIDEO)
    fun provideVideoDataSource(movieProvider: MovieProvider): CardDataProvider {
        return VideoDataSource(movieProvider, VideoFactory())
    }
}