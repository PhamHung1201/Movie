package com.hungpham.ui_actor.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.data.DataRepository
import com.hungpham.ui_actor.Actor
import com.hungpham.ui_actor.ActorCardItem

class ActorDataSource(private val dataRepository: DataRepository) : CardDataProvider {

    override suspend fun dataSource(): CardItem {
        val actorData = dataRepository.getActors()
        val actors = actorData
            .map {
                Actor(it.id, it.name, it.avatar.medium)
            }.toList()
        return ActorCardItem(actors)
    }
}