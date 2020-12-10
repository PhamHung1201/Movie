package com.hungpham.ui_trending.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.movie_support.MovieProvider
import com.hungpham.ui_trending.TrendingCardItem
import com.hungpham.ui_trending.TrendingMovie
import io.reactivex.Observable


class TrendingDataSource(private val movieProvider: MovieProvider) : CardDataProvider {

    override fun dataSource(): Observable<CardItem> {
        return movieProvider.getTrendingMovie()
            .toObservable()
            .map { movies ->
                return@map movies.map {
                    TrendingMovie(id = it.id, name = it.name, it.poster.medium)
                }
            }
            .map {
                TrendingCardItem("You will see Trending", it)
            }
    }

    override fun dataSource(id: Long): Observable<CardItem> {
        TODO("Not yet implemented")
    }
}