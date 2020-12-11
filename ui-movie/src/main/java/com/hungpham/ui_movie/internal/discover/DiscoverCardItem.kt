package com.hungpham.ui_movie.internal.discover

import com.hungpham.card_kit.CardItem
import com.hungpham.card_kit.CardType

data class DiscoverCardItem(val shortContent: String, val movieItems: List<DiscoverMovie>) : CardItem {

    override val cardType: CardType
        get() = CardType.DISCOVER

}