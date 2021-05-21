package com.hddroid.clean.presentation.intent

import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEvent

sealed class MainActivityViewEvent: CoreViewEvent {
    object OnScreenLoad: MainActivityViewEvent()
    object OnBackPressed: MainActivityViewEvent()
}