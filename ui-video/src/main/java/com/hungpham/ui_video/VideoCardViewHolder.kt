package com.hungpham.ui_video

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.card_kit.CardViewHolder
import dagger.Lazy


class VideoCardViewHolder(itemView: View, private val videoAdapter: Lazy<VideoAdapter>) :
    CardViewHolder(itemView) {

    private val rvVideos: RecyclerView by lazy { itemView.findViewById(R.id.rvVideos) }

    companion object {
        fun create(
            parent: ViewGroup,
            layoutInflater: LayoutInflater,
            videoAdapter: Lazy<VideoAdapter>
        ): VideoCardViewHolder {
            val view = layoutInflater.inflate(R.layout.view_video_card, parent, false)
            return VideoCardViewHolder(view, videoAdapter)
        }
    }

    override fun onBind(item: Any) {
        item as VideoCardItem
        setupRecyclerView(item.videos)
    }

    private fun setupRecyclerView(movieItems: List<Video>) {
        rvVideos.adapter = videoAdapter.get()
        videoAdapter.get().submitList(movieItems)
    }
}