package com.hddroid.clean.core.presentation.view.base.contract

import com.hddroid.clean.core.presentation.view.base.BaseViewNavigation

interface ViewNavigationContract<VN: BaseViewNavigation> {
    fun doNavigate(it: VN)
}