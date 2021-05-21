package com.hddroid.clean.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.hddroid.clean.core.domain.usecase.UseCaseHandler
import com.hddroid.clean.core.presentation.viewmodel.BaseViewModelWithEffect
import com.hddroid.clean.domain.usecase.GetLaunchScreenData
import com.hddroid.clean.domain.model.LaunchScreenParams
import com.hddroid.clean.domain.model.LaunchScreenResult
import com.hddroid.clean.presentation.intent.MainActivityViewEffect
import com.hddroid.clean.presentation.intent.MainActivityViewEvent
import com.hddroid.clean.presentation.intent.MainActivityViewState
import com.hddroid.clean.presentation.model.MainErrorUIModel
import com.hddroid.clean.presentation.model.MainUIDisplayModel
import kotlinx.coroutines.launch

class MainActivityViewModel(private val loadLaunchScreenUseCase: GetLaunchScreenData)
    : BaseViewModelWithEffect<MainActivityViewEvent, MainActivityViewState, MainActivityViewEffect>(
    MainActivityViewState.LoadingState
) {
    override fun processEvent(event: MainActivityViewEvent) {
        when (event) {
            MainActivityViewEvent.OnScreenLoad -> {
                viewModelScope.launch {
                    kotlin.runCatching {
                        UseCaseHandler<LaunchScreenParams, LaunchScreenResult>().execute(loadLaunchScreenUseCase,
                            LaunchScreenParams()
                        )
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
                                setViewEffect(MainActivityViewEffect.HideError)
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

class MainActivityViewModelFactory constructor(private val loadLaunchScreenUseCase: GetLaunchScreenData): ViewModelProvider.Factory {
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