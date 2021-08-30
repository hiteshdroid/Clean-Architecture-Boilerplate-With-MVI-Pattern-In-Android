package com.hddroid.clean.di.module

import com.hddroid.clean.MainApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object InfraProvider {
    @JvmStatic
    fun init(app: MainApplication) {
        app.apply {
            startKoin {
                androidContext(this@apply)
                modules(
                    listOf(
                        viewModelModule
                    )
                )
            }
        }
    }
}