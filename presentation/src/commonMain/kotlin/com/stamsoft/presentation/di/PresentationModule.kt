package com.stamsoft.presentation.di

import com.stamsoft.presentation.viewmodel.ScheduleViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { ScheduleViewModel(get()) }
}
