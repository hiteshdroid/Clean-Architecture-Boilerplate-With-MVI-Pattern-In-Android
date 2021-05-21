package com.hddroid.clean.core.presentation.viewmodel.contract

import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEvent

interface ViewModelContract<VE: CoreViewEvent> {
    fun processEvent(event: VE)
}