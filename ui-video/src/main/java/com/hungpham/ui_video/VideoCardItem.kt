package com.hungpham.ui_video

import com.hungpham.card_kit.CardItem
import com.hungpham.card_kit.CardType


class VideoCardItem(val videos: List<Video>): CardItem {

    override val cardType: CardType
        get() = CardType.VIDEO
}