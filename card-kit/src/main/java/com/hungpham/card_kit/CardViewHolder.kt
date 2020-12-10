package com.hungpham.card_kit

import android.view.View
import androidx.recyclerview.widget.RecyclerView


abstract class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(item: Any)

    fun onClick(movieId: Long) {

    }
}


