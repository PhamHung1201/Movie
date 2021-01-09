package com.hungpham.feed.presenter

import com.hungpham.feed.ui.FeedView
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

class FeedPresenter(
    private val view: FeedView,
    private val provider: FeedProvider,
) {

    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    fun fetchData() {
        scope.launch {
            provider.fetch()
                .collect {
                    withContext(Dispatchers.Main) {
                        view.updateItems(it)
                    }
                }
        }
    }

    fun clear() {
        scope.cancel()
    }
}