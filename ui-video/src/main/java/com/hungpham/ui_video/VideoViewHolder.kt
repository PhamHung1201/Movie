package com.hungpham.ui_video

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.image_support.ImageDownloader


class VideoViewHolder(view: View, private val imageDownloader: ImageDownloader) :
    RecyclerView.ViewHolder(view) {

    private val previewImage: ImageView by lazy { view.findViewById(R.id.imgPreview) }

    fun bind(item: Video) {
        imageDownloader.load(item.previewImage).into(previewImage)
    }
}