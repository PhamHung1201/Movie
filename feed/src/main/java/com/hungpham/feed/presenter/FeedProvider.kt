package com.hungpham.feed.presenter

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.card_kit.CardType
import com.hungpham.feed.ui.FeedOrder
import io.reactivex.Observable


class FeedProvider(private val dataSources: Map<CardType, CardDataProvider>) {
    
    fun fetch(): Observable<CardItem> {
        val sources = arrayListOf<CardDataProvider>()

        FeedOrder.order.forEach {
            val source = dataSources[it] ?: throw NullPointerException(
                "CardType ${it.name} is not implemented yet"
            )
            sources.add(source)
        }

        //TODO Refactor this part to improve loading performance

        return Observable.concat(sources.map { it.dataSource() })
    }
}