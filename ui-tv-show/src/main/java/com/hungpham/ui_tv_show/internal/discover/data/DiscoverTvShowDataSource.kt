package com.hungpham.ui_tv_show.internal.discover.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.data.DataRepository
import com.hungpham.ui_tv_show.internal.TvShow
import com.hungpham.ui_tv_show.internal.discover.DiscoverTvShowCardItem

class DiscoverTvShowDataSource(
    private val dataRepository: DataRepository,
    private val filterFactory: DiscoverTvShowFilterFactory
) : CardDataProvider {

    override suspend fun dataSource(): CardItem {
        val tvData = dataRepository.getDiscoverTvShowBy(filterFactory.getFilters())
        val tvShows = tvData.map {
            TvShow(it.id, it.name, it.poster.medium)
        }
        return DiscoverTvShowCardItem("Discover tv show", tvShows)
    }
}