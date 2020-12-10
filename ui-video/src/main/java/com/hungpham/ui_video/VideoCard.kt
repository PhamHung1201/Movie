package com.hungpham.ui_video

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardType
import com.hungpham.card_kit.CardViewHolder
import dagger.Lazy


class VideoCard(private val videoAdapter: Lazy<VideoAdapter>) : Card {

    override fun getCardType() = CardType.VIDEO

    override fun onCreateViewHolder(
        parent: ViewGroup,
        layoutInflater: LayoutInflater
    ): CardViewHolder {
        return VideoCardViewHolder.create(parent, layoutInflater, videoAdapter)
    }

    override fun onBindViewHolder(item: Any, holder: CardViewHolder) {
        (holder as VideoCardViewHolder).onBind(item as VideoCardItem)
    }
}