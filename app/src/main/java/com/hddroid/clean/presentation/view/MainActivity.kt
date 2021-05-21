package com.hddroid.clean.presentation.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.hddroid.clean.R
import com.hddroid.clean.data.MainScreenDataSource
import com.hddroid.clean.data.MainTranslationService
import com.hddroid.clean.databinding.MainActivityBinding
import com.hddroid.clean.domain.usecase.GetLaunchScreenData
import com.hddroid.clean.domain.usecase.GetLaunchScreenDataWithParams
import com.hddroid.clean.presentation.intent.MainActivityViewEffect
import com.hddroid.clean.presentation.intent.MainActivityViewEvent
import com.hddroid.clean.presentation.intent.MainActivityViewState
import com.hddroid.clean.presentation.model.MainErrorUIModel
import com.hddroid.clean.presentation.model.MainUIDisplayModel
import com.hddroid.clean.presentation.view.base.BaseActivity
import com.hddroid.clean.presentation.viewmodel.MainActivityViewModel
import com.hddroid.clean.presentation.viewmodel.MainActivityViewModelFactory

class MainActivity :BaseActivity<MainActivityViewEvent, MainActivityViewState, MainActivityViewEffect, MainActivityViewModel, MainActivityBinding>() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.processEvent(MainActivityViewEvent.OnScreenLoad)
    }

    override fun onBackPressed() {
        viewModel.processEvent(MainActivityViewEvent.OnBackPressed)
    }

    override fun getViewModel(): MainActivityViewModel {
        viewModel = ViewModelProvider(this,
            MainActivityViewModelFactory(
                GetLaunchScreenDataWithParams(
                    MainScreenDataSource(),
                    MainTranslationService()
                )
            )
        ).get(MainActivityViewModel::class.java)
        return viewModel
    }

    override fun renderViewState(viewState: MainActivityViewState) {
        when (viewState) {
            MainActivityViewState.LoadingState -> bindLoader(true)
            is MainActivityViewState.DisplayState -> {
                bindDisplayData(viewState.displayModel)
            }
            is MainActivityViewState.ErrorState -> {
                bindErrorData(viewState.errorModel)
            }
        }
    }

    private fun bindErrorData(errorModel: MainErrorUIModel) {
        viewBinding.errorModel = errorModel
        executePendingBindings()
    }

    private fun bindLoader(showLoader: Boolean) {
        viewBinding.showLoader = showLoader
        executePendingBindings()
    }

    private fun bindDisplayData(displayModel: MainUIDisplayModel) {
        viewBinding.displayModel = displayModel
        executePendingBindings()
    }

    override fun renderViewEffects(viewEffects: MainActivityViewEffect) {
        when (viewEffects) {
            MainActivityViewEffect.Exit -> finish()
            MainActivityViewEffect.ShowLoader -> bindLoader(true)
            MainActivityViewEffect.HideLoader -> bindLoader(false)
        }
    }

    override fun getLayout() = R.layout.main_activity
}