package com.hungpham.ui_movie.internal.trending

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.image_support.ImageDownloader
import com.hungpham.ui_movie.R


class TrendingMovieItemViewHolder(view: View, private val imageDownloader: ImageDownloader) :
    RecyclerView.ViewHolder(view) {
    private val tvMovieName: TextView by lazy { view.findViewById<TextView>(R.id.tvMovieName) }
    private val imgPoster: ImageView by lazy { view.findViewById<ImageView>(R.id.imgPoster) }

    fun bind(item: TrendingMovie) {
        tvMovieName.text = item.name
        imageDownloader.load(item.posterUrl).into(imgPoster)
    }
}