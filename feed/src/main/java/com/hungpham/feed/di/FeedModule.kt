package com.hungpham.feed.di

import android.content.Context
import android.view.LayoutInflater
import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardType
import com.hungpham.card_kit.recycler.CardManager
import com.hungpham.card_kit.recycler.DelegationAdapter
import com.hungpham.feed.presenter.FeedPresenter
import com.hungpham.feed.presenter.FeedProvider
import com.hungpham.feed.ui.FeedView
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
object FeedModule {

    @Provides
    fun provideDelegationAdapter(
        cards: Set<@JvmSuppressWildcards Card>,
        cardManager: CardManager
    ): DelegationAdapter {
        return DelegationAdapter(cards, cardManager)
    }

    @Provides
    fun provideLayoutInflater(context: Context): LayoutInflater {
        return LayoutInflater.from(context)
    }

    @Provides
    fun provideFeedPresenter(view: FeedView, feedProvider: FeedProvider): FeedPresenter {
        return FeedPresenter(view, feedProvider, CompositeDisposable())
    }

    @Provides
    fun provideFeedProvider(dataSources: Map<CardType, @JvmSuppressWildcards CardDataProvider>): FeedProvider {
        return FeedProvider(dataSources)
    }

    @Provides
    fun provideCardManager(layoutInflater: LayoutInflater): CardManager {
        return CardManager(layoutInflater)
    }
}