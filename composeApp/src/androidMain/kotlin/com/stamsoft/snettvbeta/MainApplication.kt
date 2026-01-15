package com.stamsoft.snettvbeta

import android.app.Application
import com.stamsoft.data.di.dataModule
import com.stamsoft.domain.di.domainModule
import com.stamsoft.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                domainModule,
                dataModule,
                presentationModule
            )
        }
    }
}
