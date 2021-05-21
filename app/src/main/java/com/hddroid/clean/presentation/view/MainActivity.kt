package com.hddroid.clean.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import com.hddroid.clean.R
import com.hddroid.clean.core.presentation.view.BaseViewWithEffect
import com.hddroid.clean.data.MainScreenDataSource
import com.hddroid.clean.data.MainTranslationService
import com.hddroid.clean.domain.usecase.GetLaunchScreenData
import com.hddroid.clean.presentation.intent.MainActivityViewEffect
import com.hddroid.clean.presentation.intent.MainActivityViewEvent
import com.hddroid.clean.presentation.intent.MainActivityViewState
import com.hddroid.clean.presentation.viewmodel.MainActivityViewModel
import com.hddroid.clean.presentation.viewmodel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity(), BaseViewWithEffect<MainActivityViewEvent, MainActivityViewState, MainActivityViewEffect, MainActivityViewModel> {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        onLifecycleOwnerAttached(this)
        viewModel.processEvent(MainActivityViewEvent.OnScreenLoad)
    }

    override fun onBackPressed() {
        viewModel.processEvent(MainActivityViewEvent.OnBackPressed)
    }

    override fun getViewModel(): MainActivityViewModel {
        viewModel = ViewModelProvider(this,
            MainActivityViewModelFactory(
                GetLaunchScreenData(
                    MainScreenDataSource(),
                    MainTranslationService()
                )
            )
        ).get(MainActivityViewModel::class.java)
        return viewModel
    }

    override fun renderViewState(viewState: MainActivityViewState) {
        when (viewState) {
            MainActivityViewState.LoadingState -> showLoader()
            is MainActivityViewState.DisplayState -> displayContent(viewState.displayModel.screenContent)
            is MainActivityViewState.ErrorState -> displayError(viewState.errorModel.header, viewState.errorModel.title, viewState.errorModel.message)
        }
    }

    private fun displayError(header: String?, title: String?, message: String?) {
        findViewById<ConstraintLayout>(R.id.error_layout).visibility = View.VISIBLE
        findViewById<TextView>(R.id.header).text = header
        findViewById<TextView>(R.id.title).text = title
        findViewById<TextView>(R.id.message).text = message
    }

    private fun hideError() {
        findViewById<ConstraintLayout>(R.id.error_layout).visibility = View.GONE
    }

    private fun displayContent(screenContent: String) {
        findViewById<TextView>(R.id.content).visibility = View.VISIBLE
        findViewById<TextView>(R.id.content).text = screenContent
    }

    private fun showLoader() {
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
    }

    private fun hideLoader() {
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
    }

    override fun renderViewEffects(viewNavigation: MainActivityViewEffect) {
        when (viewNavigation) {
            MainActivityViewEffect.Exit -> finish()
            MainActivityViewEffect.HideLoader -> hideLoader()
            MainActivityViewEffect.HideError -> hideError()
        }
    }
}