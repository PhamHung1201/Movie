package com.hungpham.feed.presenter

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.card_kit.CardType
import com.hungpham.feed.ui.FeedOrder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FeedProvider(private val dataSources: Map<CardType, CardDataProvider>) {

    suspend fun fetch(): Flow<CardItem> {
        val sources = arrayListOf<CardDataProvider>()

        FeedOrder.order.forEach {
            val source = dataSources[it] ?: throw NullPointerException(
                "CardType ${it.name} is not implemented yet"
            )
            sources.add(source)
        }

        return flow<CardItem> {
            sources.forEach {
                val data = it.dataSource()
                emit(data)
            }
        }
            .flowOn(Dispatchers.IO)
    }
}