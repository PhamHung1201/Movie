package com.hungpham.ui_image

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardType
import com.hungpham.card_kit.CardViewHolder
import dagger.Lazy


class ImageCard(private val imageAdapter: Lazy<ImageAdapter>) : Card {

    override fun getCardType() = CardType.IMAGE

    override fun onCreateViewHolder(
        parent: ViewGroup,
        layoutInflater: LayoutInflater
    ): CardViewHolder {
        return ImageCardViewHolder.create(parent, layoutInflater, imageAdapter)
    }

    override fun onBindViewHolder(item: Any, holder: CardViewHolder) {
        (holder as ImageCardViewHolder).onBind(item as ImageCardItem)
    }
}