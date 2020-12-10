package com.hungpham.ui_discover

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hungpham.image_support.ImageDownloader

class DiscoverMovieAdapter(private val imageDownloader: ImageDownloader) :
    ListAdapter<DiscoverMovie, DiscoverMovieItemViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DiscoverMovie>() {
            override fun areItemsTheSame(oldItem: DiscoverMovie, newItem: DiscoverMovie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: DiscoverMovie,
                newItem: DiscoverMovie
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverMovieItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_discover_movie, parent, false)
        return DiscoverMovieItemViewHolder(view, imageDownloader)
    }

    override fun onBindViewHolder(holder: DiscoverMovieItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}