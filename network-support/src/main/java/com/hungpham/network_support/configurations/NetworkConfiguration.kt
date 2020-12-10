package com.hungpham.network_support.configurations

import java.io.File

interface NetworkConfiguration {

    fun getApiKey(): String

    fun getHost(): String

    fun getCacheDir(): File

    fun getCacheSize(): Long

    fun getTimeoutSeconds(): Long
}