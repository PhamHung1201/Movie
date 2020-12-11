package com.hungpham.ui_movie.internal.discover.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.movie_support.MovieProvider
import com.hungpham.ui_movie.internal.discover.DiscoverCardItem
import com.hungpham.ui_movie.internal.discover.DiscoverMovie
import io.reactivex.Observable


class DiscoverDataSource(private val movieProvider: MovieProvider) : CardDataProvider {

    override fun dataSource(): Observable<CardItem> {
        return movieProvider.getDiscoverMovie(mapOf("with_genres" to "18", "sort_by" to "vote_average.desc", "vote_count.gte" to "10"))
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
}