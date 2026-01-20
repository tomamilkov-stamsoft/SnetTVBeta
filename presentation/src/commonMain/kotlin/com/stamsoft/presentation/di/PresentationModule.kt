package com.stamsoft.presentation.di

import com.stamsoft.presentation.schedule.ScheduleViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { ScheduleViewModel(get()) }
}
