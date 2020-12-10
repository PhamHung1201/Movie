package com.hungpham.ui_actor

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.image_support.ImageDownloader

class ActorViewHolder(view: View, private val imageDownloader: ImageDownloader) :
    RecyclerView.ViewHolder(view) {

    private val tvActorName: TextView by lazy { view.findViewById<TextView>(R.id.tvActorName) }
    private val imgAvatar: ImageView by lazy { view.findViewById<ImageView>(R.id.imgAvatar) }

    fun bind(item: Actor) {
        tvActorName.text = item.name
        imageDownloader.load(item.avatar).into(imgAvatar)
    }
}