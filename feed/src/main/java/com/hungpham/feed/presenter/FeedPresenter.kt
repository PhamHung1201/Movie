package com.hungpham.feed.presenter

import android.util.Log
import com.hungpham.feed.ui.FeedView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FeedPresenter(
    private val view: FeedView,
    private val provider: FeedProvider,
    private val compositeDisposable: CompositeDisposable
) {

    fun fetchData() {
        provider.fetch()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                view.updateItems(it)
            }, {
                Log.e("FeedPresenter", "fetch data failed")
            })
            .let(compositeDisposable::add)
    }
}