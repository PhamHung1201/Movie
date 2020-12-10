package com.hungpham.image_support.internal

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.HttpException
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.util.Util
import com.hungpham.image_support.GlideRotationTransformation
import com.hungpham.image_support.NetworkError

abstract class GlideImageRequester(
    private val context: Context,
    private var deferOptions: RequestOptions
) : ImageRequester {

    private fun Float.dpToPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

    private fun isValidResource(resource: Int) = resource != -1 && resource != 0

    open fun buildDrawable(view: View? = null): RequestBuilder<Drawable>? = null

    open fun buildBitmap(view: View? = null): RequestBuilder<Bitmap>? = null

    override fun placeholder(placeholderResId: Int) =
        also {
            if (isValidResource(placeholderResId)) deferOptions =
                deferOptions.placeholder(placeholderResId)
        }

    override fun placeholder(placeholderDrawable: Drawable?) =
        also { deferOptions = deferOptions.placeholder(placeholderDrawable) }

    override fun error(placeholderResId: Int) =
        also { deferOptions = deferOptions.error(placeholderResId) }

    override fun fit() = also { deferOptions = deferOptions.fitCenter() }
    override fun centerCrop() = also { deferOptions = deferOptions.centerCrop() }
    override fun centerInside() = also { deferOptions = deferOptions.centerInside() }
    override fun circleCrop() = also { deferOptions = deferOptions.circleCrop() }

    override fun rotate(degrees: Float): ImageRequester =
        also { deferOptions = deferOptions.transform(GlideRotationTransformation(degrees)) }

    override fun resize(targetWidth: Int, targetHeight: Int) =
        also { deferOptions = deferOptions.override(targetWidth, targetHeight) }

    override fun resizeDimen(targetWidthResId: Int, targetHeightResId: Int): ImageRequester {
        val resources = context.resources
        val targetWidth = resources.getDimensionPixelSize(targetWidthResId)
        val targetHeight = resources.getDimensionPixelSize(targetHeightResId)
        return resize(targetWidth, targetHeight)
    }

    override fun roundedCorner(radius: Int) = also {
        deferOptions = deferOptions.transform(
            RoundedCorners(radius)
        )
    }

    override fun rounded(cornerRadiusDp: Float): ImageRequester =
        roundedCorner(cornerRadiusDp.dpToPx())

    override fun noFade() = also { deferOptions = deferOptions.dontAnimate() }

    override fun fetch() {
        if (Util.isOnMainThread()) {
            buildDrawable()?.preload()
        } else {
            Handler(Looper.getMainLooper()).post {
                buildDrawable()?.preload()
            }
        }
    }

    override fun config(config: Bitmap.Config) = also {
        deferOptions = deferOptions.format(
            when (config) {
                Bitmap.Config.RGB_565 -> DecodeFormat.PREFER_RGB_565
                else -> DecodeFormat.PREFER_ARGB_8888
            }
        )
    }

    override fun get(): Bitmap =
        buildDrawable()!!.submit().get().let { it as BitmapDrawable }.let { it.bitmap }

    override fun getBitmap(requestListener: RequestListener<Bitmap>) {
        buildBitmap()!!.listener(requestListener).preload()
    }

    override fun into(target: ImageView?): Unit =
        target?.let { buildDrawable(it)?.into(it) }.run { Unit }

    override fun into(target: ImageView, success: () -> Unit, error: (List<Throwable>?) -> Unit) {
        buildDrawable(target)?.listener(object : RequestListener<Drawable> {

            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                val exceptions = (e?.rootCauses ?: emptyList()).mapTo(mutableListOf()) {
                    when (it is HttpException) {
                        true -> NetworkError(it.statusCode, it.message)
                        false -> it
                    }
                }
                error(exceptions)
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                success()
                return false
            }

        })?.into(target)
    }

    override fun into(target: ImageView, listener: RequestListener<Drawable>) {
        buildDrawable(target)?.listener(listener)?.into(target)
    }
}