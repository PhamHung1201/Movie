package com.hungpham.ui_tv_show.internal.popular.di

import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardKey
import com.hungpham.card_kit.CardType
import com.hungpham.image_support.ImageDownloader
import com.hungpham.movie_support.MovieProvider
import com.hungpham.ui_tv_show.internal.popular.TvShowAdapter
import com.hungpham.ui_tv_show.internal.popular.TvShowCard
import com.hungpham.ui_tv_show.internal.popular.data.TvShowDataSource
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet

@Module
object PopularTvShowModule {

    @Provides
    @IntoSet
    fun provideActorCard(actorAdapter: Lazy<TvShowAdapter>): Card {
        return TvShowCard(actorAdapter)
    }

    @Provides
    @IntoMap
    @CardKey(CardType.TV_SHOW)
    fun provideActorDataSource(movieProvider: MovieProvider): CardDataProvider {
        return TvShowDataSource(movieProvider)
    }

    @Provides
    fun provideActorAdapter(imageDownloader: ImageDownloader): TvShowAdapter {
        return TvShowAdapter(imageDownloader)
    }
}