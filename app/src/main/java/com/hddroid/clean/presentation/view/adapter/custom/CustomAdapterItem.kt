package com.hddroid.clean.presentation.view.adapter.custom

import com.hddroid.clean.core.presentation.view.base.adapter.AdapterItem
import com.hddroid.clean.core.presentation.view.base.adapter.ViewHolderFactory

class CustomAdapterItem(override val type: CustomAdapterType,
                        override val dataModel: CustomAdapterModel
) : AdapterItem<CustomAdapterType, CustomAdapterModel> {
    override fun getViewType(viewHolderFactory: ViewHolderFactory<CustomAdapterType, CustomAdapterModel>): Int {
        return viewHolderFactory.getViewType(this)
    }
}
