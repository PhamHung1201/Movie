package com.hungpham.ui_actor

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardType
import com.hungpham.card_kit.CardViewHolder
import dagger.Lazy


class ActorCard(private val actorAdapter: Lazy<ActorAdapter>): Card {

    override fun getCardType() = CardType.ACTOR

    override fun onCreateViewHolder(
        parent: ViewGroup,
        layoutInflater: LayoutInflater
    ): CardViewHolder {
        return ActorHorizontalViewHolder.create(parent, layoutInflater, actorAdapter)
    }

    override fun onBindViewHolder(item: Any, holder: CardViewHolder) {
        (holder as ActorHorizontalViewHolder).onBind(item as Actor)
    }
}