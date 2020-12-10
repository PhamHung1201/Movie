package com.hungpham.network_support

data class ExceptionModel (
    val timestamp: String,
    val status: Int,
    val error: String,
    val exception: String,
    val message: String,
    val path: String)