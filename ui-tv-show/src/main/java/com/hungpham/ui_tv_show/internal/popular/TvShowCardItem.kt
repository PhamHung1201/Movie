package com.hungpham.ui_tv_show.internal.popular

import com.hungpham.card_kit.CardItem
import com.hungpham.card_kit.CardType
import com.hungpham.ui_tv_show.internal.TvShow

data class TvShowCardItem(val shortDescription: String, val tvShows: List<TvShow>): CardItem {
    override val cardType: CardType
        get() = CardType.TV_SHOW
}