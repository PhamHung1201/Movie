package com.hungpham.image_support.internal

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.TransitionOptions
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.util.Util
import com.hungpham.image_support.errorThrowable
import com.hungpham.image_support.logError

class GlideImageDrawableRequester(
    private val context: Context,
    private var deferOptions: RequestOptions,
    private val loadResource: (RequestManager) -> RequestBuilder<Drawable>
) : GlideImageRequester(context, deferOptions) {

    private var transition: TransitionOptions<DrawableTransitionOptions, Drawable>? = null

    override fun noPlaceholder() = also { transition = DrawableTransitionOptions().dontTransition() }

    override fun crossFade() = also { transition = DrawableTransitionOptions.withCrossFade() }

    override fun buildDrawable(view: View?): RequestBuilder<Drawable>? = try {
        if (Util.isOnBackgroundThread()) {
            logError { "Should not try to set the view from background thread" }
        }

        val manager = view?.let(Glide::with) ?: Glide.with(context)

        var request = loadResource(manager).apply(deferOptions)

        transition?.let {
            request = request.transition(it)
        }

        request
    } catch (e: IllegalArgumentException) {
        /// This exception is thrown by glide when the activity is detroyed.
        /// At this point from context we don't know if it's activity or what so ever
        errorThrowable { e }
        null
    }
}