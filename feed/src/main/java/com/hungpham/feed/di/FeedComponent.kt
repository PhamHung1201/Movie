package com.hungpham.feed.di

import android.content.Context
import com.hungpham.feed.ui.FeedScreen
import com.hungpham.feed.ui.FeedView
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FeedModule::class], dependencies = [FeedDependencies::class])
interface FeedComponent {

    fun inject(screen: FeedScreen)

    @Component.Builder
    interface Builder {

        fun bindDependencies(dependencies: FeedDependencies): Builder

        @BindsInstance
        fun bindView(view: FeedView): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): FeedComponent
    }
}