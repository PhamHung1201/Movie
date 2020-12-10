package com.hungpham.ui_trending

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hungpham.image_support.ImageDownloader


class TrendingMovieAdapter(private val imageDownloader: ImageDownloader) :
    ListAdapter<TrendingMovie, TrendingMovieItemViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TrendingMovie>() {
            override fun areItemsTheSame(oldItem: TrendingMovie, newItem: TrendingMovie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TrendingMovie,
                newItem: TrendingMovie
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingMovieItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_trending_movie, parent, false)
        return TrendingMovieItemViewHolder(view, imageDownloader)
    }

    override fun onBindViewHolder(holder: TrendingMovieItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}