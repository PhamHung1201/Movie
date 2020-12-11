package com.hungpham.ui_actor.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.movie_support.MovieProvider
import com.hungpham.ui_actor.Actor
import com.hungpham.ui_actor.ActorCardItem
import io.reactivex.Observable

class ActorDataSource(private val movieProvider: MovieProvider) : CardDataProvider {

    override fun dataSource(): Observable<CardItem> {
        return movieProvider.getActors()
            .toObservable()
            .map { actors ->
                return@map actors.map {
                    Actor(it.id, it.name, it.avatar.medium)
                }
            }
            .map {
                ActorCardItem(it)
            }
    }
}