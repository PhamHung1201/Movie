package com.hungpham.ui_image

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.card_kit.CardViewHolder
import dagger.Lazy

class ImageCardViewHolder(itemView: View, private val videoAdapter: Lazy<ImageAdapter>) :
    CardViewHolder(itemView) {

    private val rvImages: RecyclerView by lazy { itemView.findViewById(R.id.rvImages) }

    companion object {
        fun create(
            parent: ViewGroup,
            layoutInflater: LayoutInflater,
            videoAdapter: Lazy<ImageAdapter>
        ): ImageCardViewHolder {
            val view = layoutInflater.inflate(R.layout.view_image_card, parent, false)
            return ImageCardViewHolder(view, videoAdapter)
        }
    }

    override fun onBind(item: Any) {
        item as ImageCardItem
        setupRecyclerView(item.images)
    }

    private fun setupRecyclerView(movieItems: List<Image>) {
        rvImages.adapter = videoAdapter.get()
        videoAdapter.get().submitList(movieItems)
    }
}