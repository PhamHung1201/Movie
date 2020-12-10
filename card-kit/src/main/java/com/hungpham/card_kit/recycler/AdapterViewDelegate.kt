package com.hungpham.card_kit.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class AdapterViewDelegate<out VH : RecyclerView.ViewHolder> {

    abstract fun isForViewType(item: Any): Boolean
    abstract fun onCreateViewHolder(parent: ViewGroup): VH
    abstract fun onBindViewHolder(item: Any, holder: RecyclerView.ViewHolder)
}