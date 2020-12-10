package com.hungpham.card_kit.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardItem
import com.hungpham.card_kit.CardViewHolder

class DelegationAdapter(
    private val cards: Set<@JvmSuppressWildcards Card>,
    private val cardManager: CardManager,
) : RecyclerView.Adapter<CardViewHolder>() {

    private val items = ArrayList<CardItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return cardManager.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        cardManager.onBindViewHolder(holder, items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return cardManager.getItemViewType(items[position])
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun init() {
        cards.forEach {
            cardManager.addCard(it)
        }
    }

    fun setItem(item: CardItem) {
        items.add(item)
        notifyDataSetChanged()
    }
}