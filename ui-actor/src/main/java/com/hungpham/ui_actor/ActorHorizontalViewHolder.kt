package com.hungpham.ui_actor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.card_kit.CardViewHolder
import dagger.Lazy

class ActorHorizontalViewHolder private constructor(
    itemView: View,
    private val actorAdapter: Lazy<ActorAdapter>
) : CardViewHolder(itemView) {

    private val rvActors: RecyclerView by lazy { itemView.findViewById(R.id.rvActors) }

    companion object {
        fun create(
            parent: ViewGroup,
            layoutInflater: LayoutInflater,
            actorAdapter: Lazy<ActorAdapter>
        ): ActorHorizontalViewHolder {
            val view = layoutInflater.inflate(R.layout.view_actor_card, parent, false)
            return ActorHorizontalViewHolder(view, actorAdapter)
        }
    }

    override fun onBind(item: Any) {
        item as ActorCardItem
        setupRecyclerView(item.actors)
    }

    private fun setupRecyclerView(movieItems: List<Actor>) {
        rvActors.adapter = actorAdapter.get()
        actorAdapter.get().submitList(movieItems)
    }
}