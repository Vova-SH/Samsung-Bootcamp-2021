package com.clean.arch.mvvm

import android.app.Application
import com.clean.arch.mvvm.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(appModule, apiModule, databaseModule)
        }
    }
}