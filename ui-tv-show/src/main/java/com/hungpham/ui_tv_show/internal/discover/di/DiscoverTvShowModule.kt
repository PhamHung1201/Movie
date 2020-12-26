package com.hungpham.ui_tv_show.internal.discover.di

import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardKey
import com.hungpham.card_kit.CardType
import com.hungpham.data.DataRepository
import com.hungpham.image_support.ImageDownloader
import com.hungpham.ui_tv_show.internal.discover.DiscoverTvShowAdapter
import com.hungpham.ui_tv_show.internal.discover.DiscoverTvShowCard
import com.hungpham.ui_tv_show.internal.discover.data.DiscoverTvShowDataSource
import com.hungpham.ui_tv_show.internal.discover.data.DiscoverTvShowFilterFactory
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet

@Module
object DiscoverTvShowModule {

    @Provides
    @IntoSet
    fun provideActorCard(actorAdapter: Lazy<DiscoverTvShowAdapter>): Card {
        return DiscoverTvShowCard(actorAdapter)
    }

    @Provides
    @IntoMap
    @CardKey(CardType.DISCOVER_TV_SHOW)
    fun provideActorDataSource(dataRepository: DataRepository): CardDataProvider {
        return DiscoverTvShowDataSource(dataRepository, DiscoverTvShowFilterFactory())
    }

    @Provides
    fun provideActorAdapter(imageDownloader: ImageDownloader): DiscoverTvShowAdapter {
        return DiscoverTvShowAdapter(imageDownloader)
    }
}