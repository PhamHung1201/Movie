package com.hungpham.ui_tv_show.internal.discover

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hungpham.image_support.ImageDownloader
import com.hungpham.tv_show_ui.R
import com.hungpham.ui_tv_show.internal.TvShow

class DiscoverTvShowAdapter(private val imageDownloader: ImageDownloader) :
    ListAdapter<TvShow, DiscoverTvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShow>() {
            override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TvShow,
                newItem: TvShow
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverTvShowViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_tv_show, parent, false)
        return DiscoverTvShowViewHolder(view, imageDownloader)
    }

    override fun onBindViewHolder(holder: DiscoverTvShowViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}