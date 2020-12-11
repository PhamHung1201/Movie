package com.hungpham.ui_tv_show.di

import com.hungpham.ui_tv_show.internal.discover.di.DiscoverTvShowModule
import com.hungpham.ui_tv_show.internal.popular.di.PopularTvShowModule
import dagger.Module

@Module(includes = [PopularTvShowModule::class, DiscoverTvShowModule::class])
object TvShowUiModule