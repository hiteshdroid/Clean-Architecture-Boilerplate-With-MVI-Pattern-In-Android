package com.hddroid.clean.presentation.intent

import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewState
import com.hddroid.clean.presentation.model.MainErrorUIModel
import com.hddroid.clean.presentation.model.MainUIDisplayModel

sealed class MainActivityViewState: CoreViewState {
    object LoadingState: MainActivityViewState()
    class DisplayState(val displayModel: MainUIDisplayModel): MainActivityViewState()
    class ErrorState(val errorModel: MainErrorUIModel): MainActivityViewState()
}