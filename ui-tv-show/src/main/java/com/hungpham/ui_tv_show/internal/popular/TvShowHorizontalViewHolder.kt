package com.hungpham.ui_tv_show.internal.popular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.card_kit.CardViewHolder
import com.hungpham.tv_show_ui.R
import com.hungpham.ui_tv_show.internal.TvShow
import dagger.Lazy

class TvShowHorizontalViewHolder private constructor(
    itemView: View,
    private val tvShowAdapter: Lazy<TvShowAdapter>
) : CardViewHolder(itemView) {

    private val rvTvShows: RecyclerView by lazy { itemView.findViewById(R.id.rvTvShows) }
    private val tvShortContent: AppCompatTextView by lazy { itemView.findViewById(R.id.tvShortContent) }

    companion object {
        fun create(
            parent: ViewGroup,
            layoutInflater: LayoutInflater,
            tvShowAdapter: Lazy<TvShowAdapter>
        ): TvShowHorizontalViewHolder {
            val view = layoutInflater.inflate(R.layout.view_tv_show_card, parent, false)
            return TvShowHorizontalViewHolder(view, tvShowAdapter)
        }
    }

    override fun onBind(item: Any) {
        item as TvShowCardItem
        tvShortContent.text = item.shortDescription
        setupRecyclerView(item.tvShows)
    }

    private fun setupRecyclerView(movieItems: List<TvShow>) {
        rvTvShows.adapter = tvShowAdapter.get()
        tvShowAdapter.get().submitList(movieItems)
    }
}