package com.stamsoft.androidtv

import android.app.Application
import com.stamsoft.di.initKoin
import org.koin.android.ext.koin.androidContext

class TvApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@TvApp)
        }
    }
}
