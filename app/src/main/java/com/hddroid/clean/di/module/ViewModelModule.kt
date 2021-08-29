package com.hddroid.clean.di.module

import com.hddroid.clean.data.MainScreenDataSource
import com.hddroid.clean.data.MainTranslationService
import com.hddroid.clean.domain.repository.LaunchScreenDataRepository
import com.hddroid.clean.domain.repository.TranslationsRepository
import com.hddroid.clean.domain.usecase.GetLaunchScreenDataWithParams
import com.hddroid.clean.presentation.viewmodel.MainActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Aravindharaj Natarajan on 29-08-2021.
 */

val viewModelModule = module {
    viewModel {
        MainActivityViewModel(get())
    }

    single<LaunchScreenDataRepository> {
        MainScreenDataSource()
    }

    single<TranslationsRepository> {
        MainTranslationService()
    }

    single {
        GetLaunchScreenDataWithParams(get(), get())
    }
}