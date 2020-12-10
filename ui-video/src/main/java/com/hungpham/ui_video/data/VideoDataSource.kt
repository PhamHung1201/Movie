package com.hungpham.ui_video.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.movie_support.MovieProvider
import com.hungpham.ui_video.VideoCardItem
import io.reactivex.Observable


class VideoDataSource(private val movieProvider: MovieProvider, private val factory: VideoFactory) :
    CardDataProvider {

    override fun dataSource(): Observable<CardItem> {

        return movieProvider.getVideoOfAMovie(1L)
            .toObservable()
            .map {
                VideoCardItem(factory.createVideos(it))
            }
    }

    override fun dataSource(id: Long): Observable<CardItem> {
        return movieProvider.getVideoOfAMovie(id)
            .toObservable()
            .map {
                VideoCardItem(factory.createVideos(it))
            }
    }
}