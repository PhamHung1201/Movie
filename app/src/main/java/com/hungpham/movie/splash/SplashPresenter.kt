package com.hungpham.movie.splash

import com.hungpham.data.DataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SplashPresenter(
    private val view: SplashView,
    private val dataRepository: DataRepository
) {
    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    fun fetchData() {
        scope.launch {
            val genres = dataRepository.getGenres()
            dataRepository.saveGenre(genres)
        }
        view.closeSplashScreen()
    }

    fun clear() {
        scope.cancel()
    }
}