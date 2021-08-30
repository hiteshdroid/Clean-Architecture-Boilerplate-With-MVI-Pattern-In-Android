package com.hddroid.clean.presentation.view

import android.os.Bundle
import com.hddroid.clean.R
import com.hddroid.clean.databinding.MainActivityBinding
import com.hddroid.clean.presentation.intent.MainActivityViewEffect
import com.hddroid.clean.presentation.intent.MainActivityViewEvent
import com.hddroid.clean.presentation.intent.MainActivityViewState
import com.hddroid.clean.presentation.model.MainErrorUIModel
import com.hddroid.clean.presentation.model.MainUIDisplayModel
import com.hddroid.clean.presentation.view.base.BaseActivity
import com.hddroid.clean.presentation.viewmodel.MainActivityViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity :
    BaseActivity<MainActivityViewEvent, MainActivityViewState, MainActivityViewEffect, MainActivityViewModel, MainActivityBinding>() {

    private val mainActivityViewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityViewModel.processEvent(MainActivityViewEvent.OnScreenLoad)
    }

    override fun onBackPressed() {
        mainActivityViewModel.processEvent(MainActivityViewEvent.OnBackPressed)
    }

    override fun getViewModel(): MainActivityViewModel {
        return mainActivityViewModel
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