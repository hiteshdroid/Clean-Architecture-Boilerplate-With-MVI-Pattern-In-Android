package com.hddroid.clean.core.presentation.view

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import com.hddroid.clean.core.presentation.view.base.BaseNavigationView
import com.hddroid.clean.core.presentation.view.base.BaseViewNavigation
import com.hddroid.clean.core.presentation.view.base.BaseViewState
import com.hddroid.clean.core.presentation.viewmodel.BaseNavigationViewModel

abstract class BaseActivity<VS: BaseViewState,
        VN: BaseViewNavigation,
        VM: BaseNavigationViewModel<VS, VN>>
    : AppCompatActivity(),
        BaseNavigationView<VS, VN, VM> {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onLifecycleOwnerAttached(this)
    }
}