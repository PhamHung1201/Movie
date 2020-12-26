package com.hungpham.login.di

import android.content.Context
import com.hungpham.login.LoginActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [LoginModule::class], dependencies = [LoginDependencies::class])
interface LoginComponent {

    fun inject(activity: LoginActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder

        fun bindDependencies(dependencies: LoginDependencies): Builder

        fun build(): LoginComponent
    }
}