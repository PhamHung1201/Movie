package com.hungpham.movie.common

import com.hungpham.network_support.configurations.SchedulerConfiguration
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class SchedulerConfigurationImpl : SchedulerConfiguration {
    override fun ioScheduler(): Scheduler {
        return Schedulers.io()
    }

    override fun mainScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()

    }
}