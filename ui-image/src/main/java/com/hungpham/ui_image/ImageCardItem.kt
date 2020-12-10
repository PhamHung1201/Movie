package com.hungpham.ui_image

import com.hungpham.card_kit.CardItem
import com.hungpham.card_kit.CardType

class ImageCardItem(val images: List<Image>) : CardItem {

    override val cardType: CardType
        get() = CardType.IMAGE
}