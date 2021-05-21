package com.hddroid.clean.core.presentation.view.contract

import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewState

interface ViewContract<VS: CoreViewState> {
    fun renderViewState(viewState: VS)
}