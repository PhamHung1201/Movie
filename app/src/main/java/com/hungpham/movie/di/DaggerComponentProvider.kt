package com.hungpham.movie.di

import com.hungpham.movie.MovieApplication

interface DaggerComponentProvider {

    fun createAppComponent(application: MovieApplication): AppComponent
}

class DaggerComponentProviderImpl : DaggerComponentProvider {

    override fun createAppComponent(application: MovieApplication): AppComponent {
        return DaggerAppComponent.factory().create(application)
    }
}