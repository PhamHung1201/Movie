package com.hungpham.ui_video.data

import com.hungpham.movie_support.VideoOfMovieData
import com.hungpham.ui_video.Video


class VideoFactory {

    fun createVideos(data: VideoOfMovieData): List<Video> {
        return data.videos.sortedByDescending { it.size }
            .map {
                Video(it.id, it.name, it.url, it.key)
            }
    }
}