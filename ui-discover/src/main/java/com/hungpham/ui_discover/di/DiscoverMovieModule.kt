package com.hungpham.ui_discover.di

import com.hungpham.image_support.ImageDownloader
import com.hungpham.ui_discover.DiscoverMovieAdapter
import dagger.Module
import dagger.Provides

@Module
object DiscoverMovieModule {

    @Provides
    fun provideDiscoverMovieAdapter(imageDownloader: ImageDownloader): DiscoverMovieAdapter {
        return DiscoverMovieAdapter(imageDownloader)
    }
}