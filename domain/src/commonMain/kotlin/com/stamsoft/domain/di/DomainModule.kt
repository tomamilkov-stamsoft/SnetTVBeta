package com.stamsoft.domain.di

import com.stamsoft.domain.usecase.GetScheduleUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetScheduleUseCase(get()) }
}
