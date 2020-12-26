package com.hungpham.ui_tv_show.internal.popular.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.data.DataRepository
import com.hungpham.ui_tv_show.internal.TvShow
import com.hungpham.ui_tv_show.internal.popular.TvShowCardItem

class TvShowDataSource(private val dataRepository: DataRepository) : CardDataProvider {

    override suspend fun dataSource(): CardItem {
        val popularTvShows = dataRepository.getPopularTvShows()
        val items = popularTvShows.map {
            TvShow(it.id, it.name, it.poster.medium)
        }
        return TvShowCardItem("Popular tv show", items)
    }
}