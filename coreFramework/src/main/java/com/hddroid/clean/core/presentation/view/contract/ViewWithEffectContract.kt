package com.hddroid.clean.core.presentation.view.contract

import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEffect
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewState

interface ViewWithEffectContract<VS: CoreViewState, VN: CoreViewEffect>: ViewContract<VS> {
    fun renderViewEffects(viewEffects: VN)
}