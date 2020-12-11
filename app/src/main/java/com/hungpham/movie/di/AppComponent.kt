package com.hungpham.movie.di

import android.app.Application
import com.hungpham.feed.di.FeedDependencies
import com.hungpham.image_support.ImageDownloader
import com.hungpham.image_support.ImageSupportModule
import com.hungpham.movie_support.MovieProvider
import com.hungpham.movie_support.MovieServices
import com.hungpham.movie.MovieApplication
import com.hungpham.movie.movies.di.MovieViewModelModule
import com.hungpham.ui_actor.di.ActorUiModule
import com.hungpham.ui_image.di.ImageUiModule
import com.hungpham.ui_movie.di.MovieUiModule
import com.hungpham.ui_tv_show.di.TvShowUiModule
import com.hungpham.ui_video.di.VideoUiModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        ImageSupportModule::class,
        MovieViewModelModule::class,
        ActorUiModule::class,
        MovieUiModule::class,
        ImageUiModule::class,
        TvShowUiModule::class,
        VideoUiModule::class
    ]
)
interface AppComponent : FeedDependencies {

    fun inject(application: MovieApplication)

    fun provideImageDownloader(): ImageDownloader

    fun provideMovieServices(): MovieServices

    fun provideMovieProvider(): MovieProvider

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): AppComponent
    }
}