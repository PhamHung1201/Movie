package com.hungpham.ui_tv_show.internal.discover

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardType
import com.hungpham.card_kit.CardViewHolder
import dagger.Lazy


class DiscoverTvShowCard(private val discoverTvShowAdapter: Lazy<DiscoverTvShowAdapter>): Card {

    override fun getCardType() = CardType.DISCOVER_TV_SHOW

    override fun onCreateViewHolder(
        parent: ViewGroup,
        layoutInflater: LayoutInflater
    ): CardViewHolder {
        return DiscoverTvShowHorizontalViewHolder.create(parent, layoutInflater, discoverTvShowAdapter)
    }

    override fun onBindViewHolder(item: Any, holder: CardViewHolder) {
        (holder as DiscoverTvShowHorizontalViewHolder).onBind(item as DiscoverTvShowCardItem)
    }
}