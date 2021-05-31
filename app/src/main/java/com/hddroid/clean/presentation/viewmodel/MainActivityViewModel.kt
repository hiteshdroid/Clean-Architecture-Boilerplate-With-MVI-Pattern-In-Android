package com.hddroid.clean.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.hddroid.clean.core.domain.usecase.UseCaseHandler
import com.hddroid.clean.core.presentation.viewmodel.BaseViewModelWithEffect
import com.hddroid.clean.domain.model.LaunchScreenResult
import com.hddroid.clean.domain.usecase.GetLaunchScreenDataWithParams
import com.hddroid.clean.presentation.intent.MainActivityViewEffect
import com.hddroid.clean.presentation.intent.MainActivityViewEvent
import com.hddroid.clean.presentation.intent.MainActivityViewState
import com.hddroid.clean.presentation.model.MainErrorUIModel
import com.hddroid.clean.presentation.model.MainUIDisplayModel
import kotlinx.coroutines.launch

class MainActivityViewModel(private val loadLaunchScreenUseCase: GetLaunchScreenDataWithParams)
    : BaseViewModelWithEffect<MainActivityViewEvent, MainActivityViewState, MainActivityViewEffect>(
    MainActivityViewState.LoadingState
) {
    override fun processEvent(event: MainActivityViewEvent) {
        when (event) {
            MainActivityViewEvent.OnScreenLoad -> {
                viewModelScope.launch {
                    kotlin.runCatching {
                        UseCaseHandler().execute(loadLaunchScreenUseCase)
                    }.onSuccess {
                        when (it) {
                            is LaunchScreenResult.SuccessResult -> {
                                setViewState(
                                    MainActivityViewState.DisplayState(
                                        MainUIDisplayModel(
                                            it.screenContent
                                        )
                                    )
                                )
                                setViewEffect(MainActivityViewEffect.HideLoader)
                            }
                            is LaunchScreenResult.ErrorResult -> {
                                setViewEffect(MainActivityViewEffect.HideLoader)
                                setViewState(
                                    MainActivityViewState.ErrorState(
                                        MainErrorUIModel(
                                            it.header,
                                            it.title,
                                            it.message
                                        )
                                    )
                                )
                            }
                        }
                    }.onFailure {
                        setViewEffect(MainActivityViewEffect.HideLoader)
                        setViewState(
                            MainActivityViewState.ErrorState(
                                MainErrorUIModel(
                                    "Some generic header",
                                    "Some generic title",
                                    "Some generic message"
                                )
                            )
                        )
                    }
                }
            }
            MainActivityViewEvent.OnBackPressed -> setViewEffect(
                MainActivityViewEffect.Exit
            )
        }
    }
}

class MainActivityViewModelFactory constructor(private val loadLaunchScreenUseCase: GetLaunchScreenDataWithParams): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            MainActivityViewModel(
                loadLaunchScreenUseCase
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}