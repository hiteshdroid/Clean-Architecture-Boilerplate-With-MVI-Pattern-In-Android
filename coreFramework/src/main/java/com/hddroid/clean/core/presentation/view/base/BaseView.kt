package com.hddroid.clean.core.presentation.view.base

import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.hddroid.clean.core.presentation.view.base.contract.ViewStateContract
import com.hddroid.clean.core.presentation.viewmodel.BaseStateViewModel

interface BaseView<VS: BaseViewState, VM: BaseStateViewModel<VS>> : ViewStateContract<VS> {

    fun onLifecycleOwnerAttached(lifecycleOwner: LifecycleOwner) {
        observeLiveData(lifecycleOwner)
    }

    @CallSuper
    open fun observeLiveData(lifecycleOwner: LifecycleOwner) {
        getViewModel().stateEvent().observe(lifecycleOwner, Observer {
            renderState(it)
        })
    }

    fun getViewModel(): VM
}