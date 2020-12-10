package com.hungpham.image_support

import android.content.Context
import com.hungpham.image_support.internal.GlideImageDownloader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ImageSupportModule {

    @Provides
    @Singleton
    fun provideImageDownloader(context: Context): ImageDownloader {
        return GlideImageDownloader(context)
    }
}