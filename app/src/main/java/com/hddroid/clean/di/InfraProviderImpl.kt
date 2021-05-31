package com.hddroid.clean.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.hddroid.clean.data.MainScreenDataSource
import com.hddroid.clean.data.MainTranslationService
import com.hddroid.clean.domain.usecase.GetLaunchScreenDataWithParams
import com.hddroid.clean.presentation.viewmodel.MainActivityViewModel

class InfraProviderImpl(val context: Context): InfraProvider {
    override val mainViewModelFactory: Lazy<ViewModelProvider.Factory>
        get() = lazy {
            viewModelFactory {
                MainActivityViewModel(launchScreenUseCase)
            }
        }

    private val launchScreenUseCase = GetLaunchScreenDataWithParams(MainScreenDataSource(), MainTranslationService())
}
