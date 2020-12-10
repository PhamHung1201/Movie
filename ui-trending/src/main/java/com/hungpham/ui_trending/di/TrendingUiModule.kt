package com.hungpham.ui_trending.di

import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardKey
import com.hungpham.card_kit.CardType
import com.hungpham.movie_support.MovieProvider
import com.hungpham.ui_trending.TrendingMovieAdapter
import com.hungpham.ui_trending.TrendingMovieCard
import com.hungpham.ui_trending.data.TrendingDataSource
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet


@Module(includes = [TrendingMovieModule::class])
object TrendingUiModule {

    @Provides
    @IntoSet
    fun provideDiscoverMovieFeed(movieAdapter: Lazy<TrendingMovieAdapter>): Card {
        return TrendingMovieCard(movieAdapter)
    }

    @Provides
    @IntoMap
    @CardKey(CardType.TRENDING)
    fun provideTrendingDataSource(movieProvider: MovieProvider): CardDataProvider {
        return TrendingDataSource(movieProvider)
    }
}