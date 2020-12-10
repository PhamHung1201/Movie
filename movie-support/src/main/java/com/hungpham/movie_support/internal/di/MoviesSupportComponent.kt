package com.hungpham.movie_support.internal.di

import com.hungpham.movie_support.MovieProvider
import com.hungpham.movie_support.MovieServices
import dagger.Component

@Component(modules = [MoviesSupportModule::class])
interface MoviesSupportComponent {
    fun moviesService(): MovieServices

    fun movieProvider(): MovieProvider
}