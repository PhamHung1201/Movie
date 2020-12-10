package com.hungpham.image_support

import java.io.IOException


data class NetworkError(
    val statusCode: Int,
    override val message: String? = null

) : IOException(message)