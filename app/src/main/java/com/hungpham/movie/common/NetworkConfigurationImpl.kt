package com.hungpham.movie.common

import com.hungpham.network_support.configurations.NetworkConfiguration
import com.hungpham.movie.BuildConfig
import java.io.File

class NetworkConfigurationImpl(private val cacheDir: File) : NetworkConfiguration {
    private val TEN_MEGABYTE = 10 * 1024 * 1024L

    override fun getApiKey() = BuildConfig.TMDB_API_KEY

    override fun getHost() = "https://api.themoviedb.org/3/"

    override fun getCacheDir() = cacheDir

    override fun getCacheSize() = TEN_MEGABYTE

    override fun getTimeoutSeconds() = 30L
}