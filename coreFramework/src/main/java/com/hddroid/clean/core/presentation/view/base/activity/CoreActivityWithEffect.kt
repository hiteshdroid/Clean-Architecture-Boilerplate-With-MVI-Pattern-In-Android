package com.hddroid.clean.core.presentation.view.base.activity

import androidx.databinding.ViewDataBinding
import com.hddroid.clean.core.presentation.view.contract.BaseViewWithEffect
import com.hddroid.clean.core.presentation.viewmodel.BaseViewModelWithEffect
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEffect
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewEvent
import com.hddroid.clean.core.presentation.viewmodel.intent.CoreViewState

abstract class CoreActivityWithEffect<VB: ViewDataBinding, VE: CoreViewEvent, VS: CoreViewState, VN: CoreViewEffect, VM: BaseViewModelWithEffect<VE, VS, VN>>: CoreActivity<VB, VE, VS, VM>(), BaseViewWithEffect<VE, VS, VN, VM>