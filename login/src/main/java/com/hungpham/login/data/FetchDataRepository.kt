package com.hungpham.login.data

import com.hungpham.data.DataRepository

class FetchDataRepository(private val dataRepository: DataRepository) {

    suspend fun fetchData() {
        dataRepository.getGenres()
    }
}