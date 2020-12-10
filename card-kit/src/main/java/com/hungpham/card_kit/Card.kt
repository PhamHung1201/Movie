package com.hungpham.card_kit

import android.view.LayoutInflater
import android.view.ViewGroup

interface Card {

    fun getCardType(): CardType

    fun onCreateViewHolder(parent: ViewGroup, layoutInflater: LayoutInflater): CardViewHolder

    fun onBindViewHolder(item: Any, holder: CardViewHolder)
}