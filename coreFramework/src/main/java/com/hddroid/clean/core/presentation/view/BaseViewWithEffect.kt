package com.hddroid.clean.core.presentation.view

import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.hddroid.clean.core.presentation.view.contract.ViewWithEffectContract
import com.hddroid.clean.core.presentation.viewmodel.BaseViewModelWithEffect
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEffect
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEvent
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewState

interface BaseViewWithEffect<VE: CoreViewEvent, VS: CoreViewState, VN: CoreViewEffect, VM: BaseViewModelWithEffect<VE, VS, VN>>
    : BaseView<VE, VS, VM>, ViewWithEffectContract<VS, VN> {

    @JvmDefault
    @CallSuper
    override fun observeLiveData(lifecycleOwner: LifecycleOwner) {
        super.observeLiveData(lifecycleOwner)
        getViewModel().viewEffect().observe(lifecycleOwner, Observer {
            renderViewEffects(it)
        })
    }
}