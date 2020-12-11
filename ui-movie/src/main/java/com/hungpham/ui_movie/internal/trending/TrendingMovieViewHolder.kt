package com.hungpham.ui_movie.internal.trending

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.card_kit.CardViewHolder
import com.hungpham.ui_movie.R
import dagger.Lazy


class TrendingMovieViewHolder(
    itemView: View,
    private val movieAdapter: Lazy<TrendingMovieAdapter>,
) : CardViewHolder(itemView) {

    private val tvShortContent: AppCompatTextView by lazy {
        itemView.findViewById<AppCompatTextView>(
            R.id.tvShortContent
        )
    }
    private val rvTrendingMovie: RecyclerView by lazy { itemView.findViewById<RecyclerView>(R.id.rvTrendingMovie) }

    companion object {
        fun create(
            parent: ViewGroup,
            layoutInflater: LayoutInflater,
            movieAdapter: Lazy<TrendingMovieAdapter>
        ): TrendingMovieViewHolder {
            val inflatedView =
                layoutInflater.inflate(R.layout.view_trending_card, parent, false)
            return TrendingMovieViewHolder(inflatedView, movieAdapter)
        }
    }

    override fun onBind(item: Any) {
        item as TrendingCardItem
        tvShortContent.text = item.shortContent
        setupRecyclerView(item.items)
    }

    private fun setupRecyclerView(movieItems: List<TrendingMovie>) {
        rvTrendingMovie.adapter = movieAdapter.get()
        movieAdapter.get().submitList(movieItems)
    }
}