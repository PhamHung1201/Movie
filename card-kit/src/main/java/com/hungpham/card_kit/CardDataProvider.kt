package com.hungpham.card_kit

interface CardDataProvider {

    suspend fun dataSource(): CardItem
}