package com.stamsoft.di

import com.stamsoft.data.di.dataModule
import com.stamsoft.domain.di.domainModule
import com.stamsoft.presentation.di.presentationModule

val appModules = listOf(
    presentationModule,
    domainModule,
    dataModule
)
