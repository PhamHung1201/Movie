package com.hungpham.ui_tv_show.internal.popular.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.movie_support.MovieProvider
import com.hungpham.ui_tv_show.internal.TvShow
import com.hungpham.ui_tv_show.internal.popular.TvShowCardItem
import io.reactivex.Observable

class TvShowDataSource(private val movieProvider: MovieProvider) : CardDataProvider {

    override fun dataSource(): Observable<CardItem> {
        return movieProvider.getPopularTvShows()
            .toObservable()
            .map { actors ->
                return@map actors.map {
                    TvShow(it.id, it.name, it.poster.medium)
                }
            }
            .map {
                TvShowCardItem("Popular tv show", it)
            }
    }
}