package com.hddroid.clean.core.presentation.view

import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.hddroid.clean.core.presentation.view.contract.ViewContract
import com.hddroid.clean.core.presentation.viewmodel.BaseViewModel
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEvent
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewState

interface BaseView<VE: CoreViewEvent, VS: CoreViewState, VM: BaseViewModel<VE, VS>> : ViewContract<VS> {

    /**
     * Call this method when your view is ready to listen to live data events
     */

    @JvmDefault
    @CallSuper
    fun onLifecycleOwnerAttached(lifecycleOwner: LifecycleOwner) {
        observeLiveData(lifecycleOwner)
    }

    @JvmDefault
    @CallSuper
    fun observeLiveData(lifecycleOwner: LifecycleOwner) {
        getViewModel().viewState().observe(lifecycleOwner, Observer {
            renderViewState(it)
        })
    }

    fun getViewModel(): VM
}