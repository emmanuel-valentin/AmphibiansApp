package com.emmapps.amphibians

import android.app.Application
import com.emmapps.amphibians.di.AppModule
import com.emmapps.amphibians.di.DefaultAppModule

class AmphibiansApplication : Application() {
    lateinit var container: AppModule

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppModule()
    }
}