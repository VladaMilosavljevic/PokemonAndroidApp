package com.eng.pokemonapp

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }
}
