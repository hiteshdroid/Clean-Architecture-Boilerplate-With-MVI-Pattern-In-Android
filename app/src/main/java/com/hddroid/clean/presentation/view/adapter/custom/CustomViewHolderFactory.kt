package com.hddroid.clean.presentation.view.adapter.custom

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hddroid.clean.R
import com.hddroid.clean.core.presentation.view.adapter.base.AdapterItem
import com.hddroid.clean.core.presentation.view.adapter.base.BaseViewHolder
import com.hddroid.clean.core.presentation.view.adapter.base.ViewHolderFactory
import com.hddroid.clean.databinding.PrimaryBinding
import com.hddroid.clean.databinding.SecondaryBinding
import com.hddroid.clean.databinding.TertiaryBinding

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

        return when(viewType) {
            R.layout.primary -> {
                val viewBinding = PrimaryBinding.inflate(layoutInflater, parent, false)
                PrimaryViewHolder(viewBinding)
            }
            R.layout.secondary -> {
                val viewBinding = SecondaryBinding.inflate(layoutInflater, parent, false)
                    SecondaryViewHolder(viewBinding)
            }
            else -> {
                val viewBinding = TertiaryBinding.inflate(layoutInflater, parent, false)
                    TertiaryViewHolder(viewBinding)
            }
        } as BaseViewHolder<CustomAdapterType, CustomAdapterModel>
    }
}