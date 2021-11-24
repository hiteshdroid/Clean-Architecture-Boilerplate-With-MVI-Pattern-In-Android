package com.hddroid.clean.presentation.view.adapter.custom

import com.hddroid.clean.core.presentation.view.adapter.base.AdapterItem
import com.hddroid.clean.core.presentation.view.adapter.base.ViewHolderFactory

class CustomAdapterItem(override val type: CustomAdapterType,
                        override val dataModel: CustomAdapterModel
) : AdapterItem<CustomAdapterType, CustomAdapterModel> {
    override fun getViewType(viewHolderFactory: ViewHolderFactory<CustomAdapterType, CustomAdapterModel>): Int {
        return viewHolderFactory.getViewType(this)
    }
}
