package com.hddroid.clean.core.presentation.view

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.hddroid.clean.core.presentation.view.base.BaseNavigationView
import com.hddroid.clean.core.presentation.view.base.BaseViewNavigation
import com.hddroid.clean.core.presentation.view.base.BaseViewState
import com.hddroid.clean.core.presentation.viewmodel.BaseNavigationViewModel

abstract class BaseFragment<VS: BaseViewState, VN: BaseViewNavigation, VM: BaseNavigationViewModel<VS, VN>>
    : Fragment(), BaseNavigationView<VS, VN, VM> {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLifecycleOwnerAttached(viewLifecycleOwner)
    }
}