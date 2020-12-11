package com.hungpham.ui_tv_show.internal.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardType
import com.hungpham.card_kit.CardViewHolder
import dagger.Lazy


class TvShowCard(private val tvShowAdapter: Lazy<TvShowAdapter>): Card {

    override fun getCardType() = CardType.TV_SHOW

    override fun onCreateViewHolder(
        parent: ViewGroup,
        layoutInflater: LayoutInflater
    ): CardViewHolder {
        return TvShowHorizontalViewHolder.create(parent, layoutInflater, tvShowAdapter)
    }

    override fun onBindViewHolder(item: Any, holder: CardViewHolder) {
        (holder as TvShowHorizontalViewHolder).onBind(item as TvShowCardItem)
    }
}