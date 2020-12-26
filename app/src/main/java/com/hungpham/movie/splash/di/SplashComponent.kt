package com.hungpham.movie.splash.di

import com.hungpham.movie.splash.SplashScreen
import com.hungpham.movie.splash.SplashView
import dagger.BindsInstance
import dagger.Component

@Component(modules = [SplashModule::class], dependencies = [SplashDependencies::class])
interface SplashComponent {

    fun inject(activity: SplashScreen)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindView(view: SplashView): Builder

        fun bindDependencies(dependencies: SplashDependencies): Builder

        fun build(): SplashComponent
    }
}