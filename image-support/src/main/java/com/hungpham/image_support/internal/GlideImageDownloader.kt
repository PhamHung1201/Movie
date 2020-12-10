package com.hungpham.image_support.internal

import android.content.Context
import android.net.Uri
import android.os.Build
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.hungpham.image_support.ImageDownloader
import com.hungpham.image_support.log
import java.io.File

/**
 * Created by hung.pham on 3/11/20.
 */
open class GlideImageDownloader constructor(
    private val context: Context,
    private val glide: (Context) -> RequestManager = Glide::with
) : ImageDownloader {

    private fun defaultOptions(): RequestOptions {
        var options = RequestOptions()

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            /// On pre-lollipop we force lower image quality to avoid OOM
            /// This will save 50% memory footprint on each image
            /// On post newer version Glide will use Hardware bitmap for the same result without quality impact
            options = options.format(DecodeFormat.PREFER_RGB_565)
        }
        return options
    }

    override fun load(url: String?): ImageRequester {
        log { "ImageDownloader: Loading image with url=${url}" }
        return GlideImageDrawableRequester(
            context,
            defaultOptions()
        ) { it.load(if (url?.isBlank() == true) null else url) }
    }

    override fun load(@DrawableRes drawableResId: Int): ImageRequester {
        log { "ImageDownloader: Loading image with drawableResId=${drawableResId}" }
        return GlideImageDrawableRequester(context, defaultOptions()) { it.load(drawableResId) }
    }

    override fun load(uri: Uri): ImageRequester {
        log { "ImageDownloader: Loading image with uri=${uri}" }
        return GlideImageDrawableRequester(context, defaultOptions()) { it.load(uri) }
    }

    override fun load(file: File): ImageRequester {
        log { "ImageDownloader: Loading image with file" }
        return GlideImageDrawableRequester(context, defaultOptions()) { it.load(file) }
    }

    override fun loadAsBitmap(url: String?): ImageRequester {
        return GlideImageBitmapRequester(context, defaultOptions()) { it.asBitmap().load(url) }
    }

    override fun loadAsBitmap(drawableResId: Int): ImageRequester {
        return GlideImageBitmapRequester(context, defaultOptions()) { it.asBitmap().load(drawableResId) }
    }

    override fun cancel(imageView: ImageView) = glide(context).clear(imageView)

}