package com.hddroid.clean.core.presentation.view.adapter.custom

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hddroid.clean.core.R
import com.hddroid.clean.core.presentation.view.adapter.base.AdapterItem
import com.hddroid.clean.core.presentation.view.adapter.base.BaseViewHolder
import com.hddroid.clean.core.presentation.view.adapter.base.ViewHolderFactory

class CustomViewHolderFactory: ViewHolderFactory<CustomAdapterType, CustomAdapterModel> {
    override fun getViewType(item: AdapterItem<CustomAdapterType, CustomAdapterModel>): Int {
        return when(item.type) {
            CustomAdapterType.Primary -> R.layout.primary
            CustomAdapterType.Secondary -> R.layout.secondary
            CustomAdapterType.Tertiary -> R.layout.tertiary
        }
    }

    override fun createViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<CustomAdapterType, CustomAdapterModel> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewForHolder = layoutInflater.inflate(viewType, parent, false)
        return when(viewType) {
            R.layout.primary -> {
                PrimaryViewHolder(viewForHolder)
            }
            R.layout.secondary -> {
                SecondaryViewHolder(viewForHolder)
            }
            else -> {
                TertiaryViewHolder(viewForHolder)
            }
        } as BaseViewHolder<CustomAdapterType, CustomAdapterModel>
    }
}