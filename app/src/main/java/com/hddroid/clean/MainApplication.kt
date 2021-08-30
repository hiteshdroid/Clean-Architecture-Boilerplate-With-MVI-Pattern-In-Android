package com.hddroid.clean

import android.app.Application
import com.hddroid.clean.di.module.InfraProvider

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        InfraProvider.init(this)
    }
}
