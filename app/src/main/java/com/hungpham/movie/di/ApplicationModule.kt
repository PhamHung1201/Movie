package com.hungpham.movie.di

import android.app.Application
import android.content.Context
import com.hungpham.network_support.NetworkObjectGraph
import com.hungpham.network_support.configurations.NetworkConfiguration
import com.hungpham.network_support.configurations.SchedulerConfiguration
import com.hungpham.movie.common.NetworkConfigurationImpl
import com.hungpham.movie.common.SchedulerConfigurationImpl
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
open class ApplicationModule {

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context = application

    @Provides
    open fun provideNetworkConfiguration(application: Application): NetworkConfiguration {
        return NetworkConfigurationImpl(application.cacheDir)
    }

    @Provides
    fun provideSchedulerConfiguration(): SchedulerConfiguration {
        return SchedulerConfigurationImpl()
    }

    @Provides
    @Singleton
    fun provideNetworkObjectGraph(
        networkConfiguration: NetworkConfiguration,
        schedulerConfiguration: SchedulerConfiguration
    ): NetworkObjectGraph {
        return NetworkObjectGraph(networkConfiguration, schedulerConfiguration)
    }

    @Provides
    @Singleton
    open fun provideRetrofit(networkObjectGraph: NetworkObjectGraph): Retrofit {
        return networkObjectGraph.retrofit()
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}