package com.stamsoft.snettvbeta

import com.stamsoft.data.di.dataModule
import com.stamsoft.domain.di.domainModule
import com.stamsoft.presentation.di.presentationModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            domainModule,
            dataModule,
            presentationModule
        )
    }
}
