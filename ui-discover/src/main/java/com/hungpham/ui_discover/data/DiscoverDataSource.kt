package com.hungpham.ui_discover.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.movie_support.MovieProvider
import com.hungpham.ui_discover.DiscoverCardItem
import com.hungpham.ui_discover.DiscoverMovie
import io.reactivex.Observable


class DiscoverDataSource(private val movieProvider: MovieProvider) : CardDataProvider {

    override fun dataSource(): Observable<CardItem> {
        return movieProvider.getDiscoverMovie()
            .toObservable()
            .map { movies ->
                return@map movies.map {
                    DiscoverMovie(id = it.id, name = it.name, it.poster.medium)
                }
            }
            .map {
                DiscoverCardItem("You will see Discover", it)
            }
    }

    override fun dataSource(id: Long): Observable<CardItem> {
        TODO("Not yet implemented")
    }
}