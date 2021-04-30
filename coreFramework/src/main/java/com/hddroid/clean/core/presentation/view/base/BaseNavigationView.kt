package com.hddroid.clean.core.presentation.view.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.hddroid.clean.core.presentation.view.base.contract.ViewNavigationContract
import com.hddroid.clean.core.presentation.viewmodel.BaseNavigationViewModel

interface BaseNavigationView<VS: BaseViewState, VN: BaseViewNavigation, VM: BaseNavigationViewModel<VS, VN>>
    : BaseView<VS, VM>, ViewNavigationContract<VN> {

    override fun observeLiveData(lifecycleOwner: LifecycleOwner) {
        super.observeLiveData(lifecycleOwner)
        getViewModel().navigationEvent().observe(lifecycleOwner, Observer {
            doNavigate(it)
        })
    }
}