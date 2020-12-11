package com.hungpham.ui_movie.internal.trending

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardType
import com.hungpham.card_kit.CardViewHolder
import dagger.Lazy


class TrendingMovieCard(private val movieAdapter: Lazy<TrendingMovieAdapter>): Card {

    override fun getCardType() = CardType.TRENDING

    override fun onCreateViewHolder(
        parent: ViewGroup,
        layoutInflater: LayoutInflater
    ): CardViewHolder {
        return TrendingMovieViewHolder.create(parent, layoutInflater, movieAdapter)
    }

    override fun onBindViewHolder(item: Any, holder: CardViewHolder) {
        (holder as TrendingMovieViewHolder).onBind(item as TrendingCardItem)
    }
}