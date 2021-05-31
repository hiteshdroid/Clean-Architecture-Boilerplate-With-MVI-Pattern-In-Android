package com.hddroid.clean.core.presentation.view.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.hddroid.clean.core.presentation.view.contract.BaseView
import com.hddroid.clean.core.presentation.viewmodel.BaseViewModel
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEvent
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewState

abstract class CoreFragment<VB: ViewDataBinding, VE: CoreViewEvent, VS: CoreViewState, VM: BaseViewModel<VE, VS>>:Fragment(), BaseView<VE, VS, VM> {
    abstract fun getLayout(): Int

    private var _viewBinding: VB? = null

    val viewBinding : VB
        get() = _viewBinding!!

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onLifecycleOwnerAttached(this)
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _viewBinding = DataBindingUtil.inflate(inflater, getLayout(), container, false)
        return viewBinding.root
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding.unbind()
        _viewBinding = null
    }
}