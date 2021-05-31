package com.hddroid.clean

import android.app.Application
import com.hddroid.clean.di.InfraProviderImpl

class MainApplication: Application() {
    private lateinit var infraProvider: InfraProviderImpl

    override fun onCreate() {
        super.onCreate()
        infraProvider = InfraProviderImpl(this)
    }

    fun getInfraProvider() = infraProvider
}
