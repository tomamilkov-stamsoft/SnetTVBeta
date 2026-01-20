package com.stamsoft.presentation.di

import com.stamsoft.presentation.schedule.ScheduleViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::ScheduleViewModel)
}
