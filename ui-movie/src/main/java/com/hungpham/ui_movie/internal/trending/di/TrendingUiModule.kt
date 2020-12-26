package com.hungpham.ui_movie.internal.trending.di

import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardKey
import com.hungpham.card_kit.CardType
import com.hungpham.data.DataRepository
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet


@Module(includes = [TrendingMovieModule::class])
object TrendingUiModule {

    @Provides
    @IntoSet
    fun provideDiscoverMovieFeed(movieAdapter: Lazy<com.hungpham.ui_movie.internal.trending.TrendingMovieAdapter>): Card {
        return com.hungpham.ui_movie.internal.trending.TrendingMovieCard(movieAdapter)
    }

    @Provides
    @IntoMap
    @CardKey(CardType.TRENDING)
    fun provideTrendingDataSource(dataRepository: DataRepository): CardDataProvider {
        return com.hungpham.ui_movie.internal.trending.data.TrendingDataSource(dataRepository)
    }
}