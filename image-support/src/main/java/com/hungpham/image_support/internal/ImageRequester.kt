package com.hungpham.image_support.internal

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.MainThread
import com.bumptech.glide.request.RequestListener

interface ImageRequester {

    fun noPlaceholder(): ImageRequester
    fun placeholder(@DrawableRes placeholderResId: Int): ImageRequester
    fun placeholder(placeholderDrawable: Drawable?): ImageRequester
    fun error(@DrawableRes placeholderResId: Int): ImageRequester
    fun fit(): ImageRequester
    fun centerCrop(): ImageRequester
    fun centerInside(): ImageRequester
    fun circleCrop(): ImageRequester
    fun resize(targetWidth: Int, targetHeight: Int): ImageRequester
    fun rotate(degrees: Float): ImageRequester
    fun resizeDimen(targetWidthResId: Int, targetHeightResId: Int): ImageRequester
    fun rounded(cornerRadiusDp: Float): ImageRequester
    fun noFade(): ImageRequester
    fun crossFade(): ImageRequester = this /* optional */
    fun roundedCorner(radius: Int): ImageRequester
    fun fetch()
    fun config(config: Bitmap.Config): ImageRequester

    @MainThread
    fun into(target: ImageView?)

    @MainThread
    fun into(target: ImageView, success: () -> Unit, error: (List<Throwable>?) -> Unit = {})

    @MainThread
    fun into(target: ImageView, listener: RequestListener<Drawable>)

    @MainThread
    fun getBitmap(requestListener: RequestListener<Bitmap>)

    @Throws(Exception::class)
    fun get(): Bitmap
}