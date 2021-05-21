package com.hddroid.clean.core.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hddroid.clean.core.presentation.viewmodel.contract.ViewModelContract
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEvent
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewState
import kotlinx.coroutines.launch

abstract class BaseViewModel<VE: CoreViewEvent, VS: CoreViewState>(initialState: VS) :
        ViewModel(), ViewModelContract<VE> {

    private val _state: MutableLiveData<VS> = MutableLiveData()

    protected var state: VS = initialState
        set(value) {
            field = value
            _state.value = value
        }

    init {
        state = initialState
    }

    fun viewState(): LiveData<VS> = _state

    fun getCurrentState() = state

    /**
     * Setter to modify the viewState. To be called when the viewstate is ready to be changed from ViewModel
     */
    fun setViewState(newState: VS) {
        viewModelScope.launch {
            state = newState
        }
    }
}