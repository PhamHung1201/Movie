package com.hungpham.ui_movie.internal.trending.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.data.DataRepository
import com.hungpham.ui_movie.internal.trending.TrendingCardItem
import com.hungpham.ui_movie.internal.trending.TrendingMovie

class TrendingDataSource(private val dataRepository: DataRepository) : CardDataProvider {

    override suspend fun dataSource(): CardItem {
        val trendingMovie = dataRepository.getTrendingMovie()
        val items = trendingMovie.map {
            TrendingMovie(
                id = it.id,
                name = it.name,
                it.poster.medium
            )
        }
        return TrendingCardItem("You will see Trending", items)
    }
}