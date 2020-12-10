package com.hungpham.movie

import android.app.Application
import com.hungpham.app_utils.extract_parents.ParentHost
import com.hungpham.movie.di.AppComponent
import com.hungpham.movie.di.ApplicationModule
import com.hungpham.movie.di.RootDependenciesProvider
import kotlin.reflect.KClass

class MovieApplication : Application(), ParentHost {

    private lateinit var rootDependenciesProvider: RootDependenciesProvider

    override fun onCreate() {
        super.onCreate()
        rootDependenciesProvider = RootDependenciesProvider()
        rootDependenciesProvider.setupDIInApp(this)
    }

    override fun <T : Any> extractParent(cls: KClass<T>): T? {
        return rootDependenciesProvider.extractParent(cls)
    }
}