package com.hungpham.feed.di

import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardType
import com.hungpham.image_support.ImageDownloader


interface FeedDependencies {

    val dataSources: Map<CardType, @JvmSuppressWildcards CardDataProvider>
    val cards: Set<@JvmSuppressWildcards Card>
    val imageDownloader: ImageDownloader
}