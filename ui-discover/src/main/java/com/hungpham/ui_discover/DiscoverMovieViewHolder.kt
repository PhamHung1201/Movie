package com.hungpham.ui_discover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.card_kit.CardViewHolder
import dagger.Lazy

class DiscoverMovieViewHolder(itemView: View, private val movieAdapter: Lazy<DiscoverMovieAdapter>, ) : CardViewHolder(itemView) {

    private val tvShortContent: AppCompatTextView by lazy {
        itemView.findViewById<AppCompatTextView>(
            R.id.tvShortContent
        )
    }
    private val rvDiscoverMovie: RecyclerView by lazy { itemView.findViewById<RecyclerView>(R.id.rvDiscoverMovie) }

    companion object {
        fun create(parent: ViewGroup, layoutInflater: LayoutInflater, movieAdapter: Lazy<DiscoverMovieAdapter>): DiscoverMovieViewHolder {
            val inflatedView =
                layoutInflater.inflate(R.layout.view_discover_card, parent, false)
            return DiscoverMovieViewHolder(inflatedView, movieAdapter)
        }
    }

    override fun onBind(item: Any) {
        item as DiscoverCardItem
        tvShortContent.text = item.shortContent
        setupRecyclerView(item.movieItems)

    }

    private fun setupRecyclerView(movieItems: List<DiscoverMovie>) {
        rvDiscoverMovie.adapter = movieAdapter.get()
        movieAdapter.get().submitList(movieItems)
    }
}