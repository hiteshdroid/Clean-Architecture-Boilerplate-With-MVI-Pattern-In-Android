package com.hddroid.clean.di

import androidx.lifecycle.ViewModelProvider

interface InfraProvider {
    val mainViewModelFactory: Lazy<ViewModelProvider.Factory>
}
