package com.hungpham.feed

import android.view.ViewGroup
import com.hungpham.card_kit.CardViewHolder

class UnsupportedViewHolder(private val view: ViewGroup) : CardViewHolder(view) {
    override fun onBind(item: Any) {
        //No OP
    }
}