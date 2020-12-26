package com.hungpham.movie.splash.di

import com.hungpham.data.DataRepository
import com.hungpham.movie.splash.SplashPresenter
import com.hungpham.movie.splash.SplashView
import dagger.Module
import dagger.Provides

@Module
object SplashModule {

    @Provides
    fun provideSplashPresenter(
        view: SplashView,
        dataRepository: DataRepository
    ): SplashPresenter {
        return SplashPresenter(view, dataRepository)
    }
}