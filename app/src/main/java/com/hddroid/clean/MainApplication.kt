package com.hddroid.clean

import android.app.Application
import com.hddroid.clean.di.module.KoinDI

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        KoinDI.init(this)
    }
}
