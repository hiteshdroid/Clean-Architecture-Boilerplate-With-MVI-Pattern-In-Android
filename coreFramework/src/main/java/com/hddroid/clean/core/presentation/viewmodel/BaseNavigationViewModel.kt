package com.hddroid.clean.core.presentation.viewmodel

import androidx.lifecycle.LiveData
import com.hddroid.clean.core.presentation.view.base.BaseViewNavigation
import com.hddroid.clean.core.presentation.view.base.BaseViewState
import com.hddroid.clean.core.presentation.viewmodel.customlivedata.SingleLiveEvent

abstract class BaseNavigationViewModel<VS: BaseViewState, VN: BaseViewNavigation> :
        BaseStateViewModel<VS>() {
    private val _navigation: SingleLiveEvent<VN> = SingleLiveEvent()

    private var navigationValue: VN? = null

    protected var navigation: VN
        get() = navigationValue
                ?: throw UninitializedPropertyAccessException(
                        "\"viewEffect\" was queried before being initialized"
                )
        set(value) {
            navigationValue = value
            _navigation.value = value
        }

    fun navigationEvent(): LiveData<VN> = _navigation
}