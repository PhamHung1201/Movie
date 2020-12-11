package com.hungpham.ui_tv_show.internal.discover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.card_kit.CardViewHolder
import com.hungpham.tv_show_ui.R
import com.hungpham.ui_tv_show.internal.TvShow
import dagger.Lazy

class DiscoverTvShowHorizontalViewHolder private constructor(
    itemView: View,
    private val discoverTvShowAdapter: Lazy<DiscoverTvShowAdapter>
) : CardViewHolder(itemView) {

    private val rvTvShows: RecyclerView by lazy { itemView.findViewById(R.id.rvTvShows) }
    private val tvShortContent: AppCompatTextView by lazy { itemView.findViewById(R.id.tvShortContent) }

    companion object {
        fun create(
            parent: ViewGroup,
            layoutInflater: LayoutInflater,
            discoverTvShowAdapter: Lazy<DiscoverTvShowAdapter>
        ): DiscoverTvShowHorizontalViewHolder {
            val view = layoutInflater.inflate(R.layout.view_tv_show_card, parent, false)
            return DiscoverTvShowHorizontalViewHolder(view, discoverTvShowAdapter)
        }
    }

    override fun onBind(item: Any) {
        item as DiscoverTvShowCardItem
        tvShortContent.text = item.shortDescription
        setupRecyclerView(item.tvShows)
    }

    private fun setupRecyclerView(movieItems: List<TvShow>) {
        rvTvShows.adapter = discoverTvShowAdapter.get()
        discoverTvShowAdapter.get().submitList(movieItems)
    }
}