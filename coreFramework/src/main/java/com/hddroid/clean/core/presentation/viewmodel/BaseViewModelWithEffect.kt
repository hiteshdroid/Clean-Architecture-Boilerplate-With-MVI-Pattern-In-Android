package com.hddroid.clean.core.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.hddroid.clean.core.presentation.viewmodel.customlivedata.SingleLiveEvent
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEffect
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEvent
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewState
import kotlinx.coroutines.launch

abstract class BaseViewModelWithEffect<VE: CoreViewEvent, VS: CoreViewState, VN: CoreViewEffect>(initialState: VS) :
        BaseViewModel<VE, VS>(initialState) {

    private val _effect: SingleLiveEvent<VN> = SingleLiveEvent()

    fun viewEffect(): LiveData<VN> = _effect

    /**
     * Setter to modify the view effect. To be called when the view effect is ready to be changed from the view model
     */
    fun setViewEffect(nextEffect: VN) {
        viewModelScope.launch {
            _effect.value = nextEffect
        }
    }
}