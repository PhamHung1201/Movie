package com.hungpham.login.di

import com.hungpham.data.DataRepository


interface LoginDependencies {

    val dataRepository: DataRepository
}