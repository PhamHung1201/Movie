package com.hungpham.ui_actor

import com.hungpham.card_kit.CardItem
import com.hungpham.card_kit.CardType

data class ActorCardItem(val actors: List<Actor>): CardItem {
    override val cardType: CardType
        get() = CardType.ACTOR
}