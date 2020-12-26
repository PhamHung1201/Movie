package com.hungpham.ui_movie.internal.discover.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.data.DataRepository
import com.hungpham.ui_movie.internal.discover.DiscoverCardItem
import com.hungpham.ui_movie.internal.discover.DiscoverMovie

class DiscoverDataSource(private val dataRepository: DataRepository) : CardDataProvider {

    override suspend fun dataSource(): CardItem {
        val filters = mapOf(
            "with_genres" to "18",
            "sort_by" to "vote_average.desc",
            "vote_count.gte" to "10"
        )
        val discoverMovie = dataRepository.getDiscoverMovie(filters)
        val movieItems = discoverMovie.map {
            return@map DiscoverMovie(id = it.id, name = it.name, it.poster.medium)
        }
        return DiscoverCardItem("You will see Discover", movieItems)
    }
}