package com.hungpham.ui_tv_show.internal.discover.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.movie_support.MovieProvider
import com.hungpham.ui_tv_show.internal.discover.DiscoverTvShowCardItem
import com.hungpham.ui_tv_show.internal.TvShow
import io.reactivex.Observable

class DiscoverTvShowDataSource(
    private val movieProvider: MovieProvider,
    private val filterFactory: DiscoverTvShowFilterFactory
) : CardDataProvider {

    override fun dataSource(): Observable<CardItem> {
        return movieProvider.getDiscoverTvShowBy(filterFactory.getFilters())
            .toObservable()
            .map { actors ->
                return@map actors.map {
                    TvShow(it.id, it.name, it.poster.medium)
                }
            }
            .map {
                DiscoverTvShowCardItem("Discover tv show", it)
            }
    }
}