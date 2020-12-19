package com.hungpham.login.di

import com.hungpham.login.data.LoginDataSource
import com.hungpham.login.data.LoginRepository
import com.hungpham.login.ui.login.LoginViewModel
import dagger.Module
import dagger.Provides

@Module
object LoginModule {

    @Provides
    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(LoginRepository(LoginDataSource()))
    }
}