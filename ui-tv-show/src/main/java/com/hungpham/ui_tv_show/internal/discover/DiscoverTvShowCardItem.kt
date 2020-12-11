package com.hungpham.ui_tv_show.internal.discover

import com.hungpham.card_kit.CardItem
import com.hungpham.card_kit.CardType
import com.hungpham.ui_tv_show.internal.TvShow

data class DiscoverTvShowCardItem(val shortDescription: String, val tvShows: List<TvShow>): CardItem {
    override val cardType: CardType
        get() = CardType.DISCOVER_TV_SHOW
}