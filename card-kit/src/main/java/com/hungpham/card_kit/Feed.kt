package com.hungpham.card_kit

import android.view.LayoutInflater
import android.view.ViewGroup

@Deprecated("use Card instead")
interface Feed {

    fun getFeedType(): CardType

    fun getFeedViewHolder(parent: ViewGroup, layoutInflater: LayoutInflater): CardViewHolder
}