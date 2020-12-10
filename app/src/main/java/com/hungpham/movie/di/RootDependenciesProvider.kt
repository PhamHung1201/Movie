package com.hungpham.movie.di

import com.hungpham.app_utils.extract_parents.ParentHost
import com.hungpham.feed.di.FeedDependencies
import com.hungpham.movie.MovieApplication
import kotlin.reflect.KClass


class RootDependenciesProvider(private val daggerComponentProvider: DaggerComponentProvider = DaggerComponentProviderImpl()) :
    ParentHost {
    private lateinit var component: AppComponent

    fun setupDIInApp(app: MovieApplication) {
        component = daggerComponentProvider.createAppComponent(app)
        component.inject(app)
    }

    override fun <T : Any> extractParent(cls: KClass<T>): T? {
        return when (cls) {
            FeedDependencies::class -> component as T
            else -> null
        }
    }


}