package com.hddroid.clean.presentation.intent

import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEffect

sealed class MainActivityViewEffect: CoreViewEffect {
    object Exit: MainActivityViewEffect()
    object HideLoader: MainActivityViewEffect()
    object HideError: MainActivityViewEffect()
}