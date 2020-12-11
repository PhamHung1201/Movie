package com.hungpham.ui_movie.di

import com.hungpham.ui_movie.internal.discover.di.DiscoverUiModule
import com.hungpham.ui_movie.internal.trending.di.TrendingUiModule
import dagger.Module


@Module(includes = [DiscoverUiModule::class, TrendingUiModule::class])
object MovieUiModule {

}