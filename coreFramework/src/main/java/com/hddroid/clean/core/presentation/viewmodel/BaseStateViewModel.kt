package com.hddroid.clean.core.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hddroid.clean.core.presentation.view.base.BaseViewState

abstract class BaseStateViewModel<VS: BaseViewState> :
        ViewModel() {

    private val _state: MutableLiveData<VS> = MutableLiveData()

    private var stateValue: VS? = null

    protected var state: VS
        get() = stateValue
                ?: throw UninitializedPropertyAccessException(
                        "\"viewState\" was queried before being initialized"
                )
        set(value) {
            stateValue = value
            _state.value = value
        }

    fun stateEvent(): LiveData<VS> = _state

    fun getCurrentState() = state

    fun setCurrentState(newState: VS) {
        state = newState
    }
}