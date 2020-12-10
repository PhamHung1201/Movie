package com.hungpham.ui_discover

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardType
import com.hungpham.card_kit.CardViewHolder
import dagger.Lazy

class DiscoverMovieCard(private val movieAdapter: Lazy<DiscoverMovieAdapter>) : Card {

    override fun getCardType() = CardType.DISCOVER

    override fun onCreateViewHolder(parent: ViewGroup, layoutInflater: LayoutInflater): CardViewHolder {
        return DiscoverMovieViewHolder.create(parent, layoutInflater, movieAdapter)
    }

    override fun onBindViewHolder(item: Any, holder: CardViewHolder) {
        (holder as DiscoverMovieViewHolder).onBind(item as DiscoverCardItem)
    }
}