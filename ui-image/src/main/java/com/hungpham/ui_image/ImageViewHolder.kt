package com.hungpham.ui_image

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.image_support.ImageDownloader

class ImageViewHolder(view: View, private val imageDownloader: ImageDownloader) :
    RecyclerView.ViewHolder(view) {

    private val previewImage: ImageView by lazy { view.findViewById(R.id.imgPreview) }

    fun bind(item: Image) {
        imageDownloader.load(item.medium).into(previewImage)
    }
}