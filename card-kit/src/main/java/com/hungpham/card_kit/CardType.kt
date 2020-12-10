package com.hungpham.card_kit

enum class CardType(val type: Int) {
    UNKNOWN(-1),
    DISCOVER(0),
    TRENDING(1),
    VIDEO(2),
    IMAGE(3),
    ACTOR(4)
}