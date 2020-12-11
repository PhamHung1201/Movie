package com.hungpham.ui_movie.internal.discover.di

import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardKey
import com.hungpham.card_kit.CardType
import com.hungpham.movie_support.MovieProvider
import com.hungpham.ui_movie.internal.discover.DiscoverMovieAdapter
import com.hungpham.ui_movie.internal.discover.DiscoverMovieCard
import com.hungpham.ui_movie.internal.discover.data.DiscoverDataSource
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet


@Module(includes = [DiscoverMovieModule::class])
object DiscoverUiModule {

    @Provides
    @IntoSet
    fun provideDiscoverMovieFeed(movieAdapter: Lazy<DiscoverMovieAdapter>): Card {
        return DiscoverMovieCard(movieAdapter)
    }

    @Provides
    @IntoMap
    @CardKey(CardType.DISCOVER)
    fun provideDiscoverDataSource(movieProvider: MovieProvider): CardDataProvider {
        return DiscoverDataSource(movieProvider)
    }
}