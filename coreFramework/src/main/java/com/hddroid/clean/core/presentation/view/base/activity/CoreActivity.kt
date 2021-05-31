package com.hddroid.clean.core.presentation.view.base.activity

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hddroid.clean.core.presentation.view.contract.BaseView
import com.hddroid.clean.core.presentation.viewmodel.BaseViewModel
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEvent
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewState

abstract class CoreActivity<VB: ViewDataBinding, VE: CoreViewEvent, VS: CoreViewState, VM: BaseViewModel<VE, VS>>: AppCompatActivity(), BaseView<VE, VS, VM> {
    abstract fun getLayout(): Int

    private var _viewBinding: VB? = null

    val viewBinding : VB
        get() = _viewBinding!!

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewBinding = DataBindingUtil.setContentView(this, getLayout())
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        viewBinding.unbind()
        _viewBinding = null
    }
}