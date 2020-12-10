package com.hungpham.card_kit.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import com.hungpham.card_kit.Card
import com.hungpham.card_kit.CardItem
import com.hungpham.card_kit.CardViewHolder

class CardManager(private val layoutInflater: LayoutInflater) {

    private val cards = SparseArrayCompat<Card>()

    fun addCard(card: Card): CardManager {
        if (cards.get(card.getCardType().type) != null) {
            throw IllegalArgumentException("A Card is already registered for the viewType = ${card.getCardType()}")
        }
        cards.put(card.getCardType().type, card)
        return this
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val card = cards.get(viewType)
            ?: throw NullPointerException("No Card added for viewType: $viewType")
        return card.onCreateViewHolder(parent, layoutInflater)
    }

    fun <VH : CardViewHolder> onBindViewHolder(holder: VH, item: CardItem) {
        val card = cards.get(holder.itemViewType)
            ?: throw NullPointerException("No card found for item at position: $item for viewType = ${holder.itemViewType}")
        card.onBindViewHolder(item, holder)
    }
    
    fun getItemViewType(item: CardItem): Int {
        val hasCard = cards.containsKey(item.cardType.type)
        if (hasCard) {
            return item.cardType.type
        } else {
            throw IllegalArgumentException("No viewType for Card: ${item.cardType}")
        }
    }
}