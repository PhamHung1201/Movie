package com.hungpham.ui_tv_show.internal.discover

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.image_support.ImageDownloader
import com.hungpham.tv_show_ui.R
import com.hungpham.ui_tv_show.internal.TvShow

class DiscoverTvShowViewHolder(view: View, private val imageDownloader: ImageDownloader) :
    RecyclerView.ViewHolder(view) {

    private val tvTvShowName: TextView by lazy { view.findViewById<TextView>(R.id.tvTvShowName) }
    private val imgPoster: ImageView by lazy { view.findViewById<ImageView>(R.id.imgPoster) }

    fun bind(item: TvShow) {
        tvTvShowName.text = item.name
        imageDownloader.load(item.poster).into(imgPoster)
    }
}