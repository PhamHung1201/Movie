package com.hungpham.ui_image.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.movie_support.MovieProvider
import com.hungpham.ui_image.ImageCardItem
import io.reactivex.Observable


class ImageDataSource(private val movieProvider: MovieProvider, private val factory: ImageFactory) :
    CardDataProvider {

    override fun dataSource(): Observable<CardItem> {
        TODO("")
    }

    override fun dataSource(id: Long): Observable<CardItem> {
        return movieProvider.getImageOfAMovie(id)
            .toObservable()
            .map {
                ImageCardItem(factory.createImages(it))
            }
    }
}