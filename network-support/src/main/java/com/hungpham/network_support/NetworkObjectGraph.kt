package com.hungpham.network_support

import com.hungpham.network_support.configurations.NetworkConfiguration
import com.hungpham.network_support.configurations.SchedulerConfiguration
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class NetworkObjectGraph(networkConfiguration: NetworkConfiguration,
                         schedulerConfiguration: SchedulerConfiguration) {

    private var component: NetworkComponent

    init {
        component = DaggerNetworkComponent.builder()
            .networkModule(NetworkModule(networkConfiguration, schedulerConfiguration))
            .build()
    }

    fun retrofit(): Retrofit {
        return component.retrofit()
    }

    fun okHttpClient(): OkHttpClient {
        return component.okHttpClient()
    }
}