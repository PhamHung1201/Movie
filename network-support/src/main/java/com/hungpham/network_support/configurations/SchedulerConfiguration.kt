package com.hungpham.network_support.configurations

import io.reactivex.Scheduler

interface SchedulerConfiguration {
    fun ioScheduler(): Scheduler

    fun mainScheduler(): Scheduler
}