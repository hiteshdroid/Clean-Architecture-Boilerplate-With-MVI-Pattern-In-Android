package com.hddroid.clean.presentation.view.adapter.custom

import com.hddroid.clean.core.presentation.view.adapter.base.AdapterItem
import com.hddroid.clean.core.presentation.view.adapter.base.BaseViewHolder
import com.hddroid.clean.databinding.SecondaryBinding

class SecondaryViewHolder(private val binding: SecondaryBinding): BaseViewHolder<CustomAdapterType.Secondary, CustomAdapterModel.Secondary>(binding) {
    override fun bind(data: AdapterItem<CustomAdapterType.Secondary, CustomAdapterModel.Secondary>) {
        binding.data = data.dataModel.someInt.toString()
        binding.executePendingBindings()
    }
}
