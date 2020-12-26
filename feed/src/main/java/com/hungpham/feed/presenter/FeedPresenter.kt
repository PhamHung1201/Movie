package com.hungpham.feed.presenter

import com.hungpham.feed.ui.FeedView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.cancel

class FeedPresenter(
    private val view: FeedView,
    private val provider: FeedProvider,
) {

    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    fun fetchData() {
        scope.launch {
            provider.fetch()
                .collect {
                    view.updateItems(it)
                }
        }
    }

    fun clear() {
        scope.cancel()
    }
}