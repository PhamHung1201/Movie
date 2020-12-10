package com.hungpham.ui_trending.di

import com.hungpham.image_support.ImageDownloader
import com.hungpham.ui_trending.TrendingMovieAdapter
import dagger.Module
import dagger.Provides


@Module
object TrendingMovieModule {

    @Provides
    fun provideTrendingMovieAdapter(imageDownloader: ImageDownloader): TrendingMovieAdapter {
        return TrendingMovieAdapter(imageDownloader)
    }
}