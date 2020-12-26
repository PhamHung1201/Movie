package com.hungpham.ui_video.data

import com.hungpham.card_kit.CardDataProvider
import com.hungpham.card_kit.CardItem
import com.hungpham.data.DataRepository
import com.hungpham.ui_video.VideoCardItem

class VideoDataSource(
    private val dataRepository: DataRepository,
    private val factory: VideoFactory
) : CardDataProvider {

    override suspend fun dataSource(): CardItem {
        val videoOfAMovie = dataRepository.getVideoOfAMovie(1L)
        return VideoCardItem(factory.createVideos(videoOfAMovie))
    }
}