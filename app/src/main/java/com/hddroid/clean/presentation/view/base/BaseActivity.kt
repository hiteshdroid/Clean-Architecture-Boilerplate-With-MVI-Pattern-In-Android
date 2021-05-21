package com.hddroid.clean.presentation.view.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hddroid.clean.core.presentation.view.BaseViewWithEffect
import com.hddroid.clean.core.presentation.viewmodel.BaseViewModelWithEffect
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEffect
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEvent
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewState

abstract class BaseActivity<VE: CoreViewEvent, VS: CoreViewState, VN: CoreViewEffect, VM: BaseViewModelWithEffect<VE, VS, VN>, VB: ViewDataBinding>: AppCompatActivity(),
    BaseViewWithEffect<VE, VS, VN, VM> {

    abstract fun getLayout(): Int

    internal lateinit var viewBinding: VB

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onLifecycleOwnerAttached(this)
        val vb: VB = DataBindingUtil.setContentView(this, getLayout())
        vb.lifecycleOwner = this
        this.viewBinding = vb
    }

    internal fun executePendingBindings() {
        viewBinding.executePendingBindings()
    }
}