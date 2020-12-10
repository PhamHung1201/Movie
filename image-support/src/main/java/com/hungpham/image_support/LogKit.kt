package com.hungpham.image_support

fun log(message: () -> String) {
    println(message)
}

fun logError(error: () -> String) {
    println(error)
}

fun errorThrowable(throwable: () -> Throwable) {
    println(throwable.toString())
}