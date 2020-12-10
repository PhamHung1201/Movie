package com.hungpham.card_kit

import io.reactivex.Observable

interface CardDataProvider {

    fun dataSource(): Observable<CardItem>

    fun dataSource(id: Long): Observable<CardItem>
}