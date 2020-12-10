package com.hungpham.ui_trending

import com.hungpham.card_kit.CardItem
import com.hungpham.card_kit.CardType

class TrendingCardItem(val shortContent: String, val items: List<TrendingMovie>): CardItem {

    override val cardType: CardType
        get() = CardType.TRENDING
}