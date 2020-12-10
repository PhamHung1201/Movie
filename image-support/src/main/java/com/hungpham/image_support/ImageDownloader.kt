package com.hungpham.image_support

import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.hungpham.image_support.internal.ImageRequester
import java.io.File

interface ImageDownloader {
    fun load(url: String?): ImageRequester

    fun load(@DrawableRes drawableResId: Int): ImageRequester

    fun load(uri: Uri): ImageRequester

    fun load(file: File): ImageRequester

    fun loadAsBitmap(url: String?): ImageRequester

    fun loadAsBitmap(@DrawableRes drawableResId: Int): ImageRequester

    fun cancel(imageView: ImageView)
}