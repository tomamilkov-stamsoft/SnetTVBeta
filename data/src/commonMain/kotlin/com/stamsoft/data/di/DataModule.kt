package com.stamsoft.data.di

import com.stamsoft.data.api.FakeTvApi
import com.stamsoft.data.api.TvApi
import com.stamsoft.data.repository.ScheduleRepositoryImpl
import com.stamsoft.domain.repository.ScheduleRepository
import org.koin.dsl.module

val dataModule = module {
    single<TvApi> { FakeTvApi() }
    single<ScheduleRepository> { ScheduleRepositoryImpl(get()) }
}
