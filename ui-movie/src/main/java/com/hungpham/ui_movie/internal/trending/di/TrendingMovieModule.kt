package com.hungpham.ui_movie.internal.trending.di

import com.hungpham.image_support.ImageDownloader
import dagger.Module
import dagger.Provides


@Module
object TrendingMovieModule {

    @Provides
    fun provideTrendingMovieAdapter(imageDownloader: ImageDownloader): com.hungpham.ui_movie.internal.trending.TrendingMovieAdapter {
        return com.hungpham.ui_movie.internal.trending.TrendingMovieAdapter(imageDownloader)
    }
}