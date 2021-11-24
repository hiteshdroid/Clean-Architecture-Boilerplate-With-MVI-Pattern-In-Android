package com.hddroid.clean.presentation.view.adapter.custom

import com.hddroid.clean.core.presentation.view.base.adapter.AdapterItem
import com.hddroid.clean.core.presentation.view.base.adapter.BaseViewHolder
import com.hddroid.clean.databinding.TertiaryBinding

class TertiaryViewHolder(private val binding: TertiaryBinding): BaseViewHolder<CustomAdapterType.Tertiary, CustomAdapterModel.Tertiary>(binding) {
    override fun bind(data: AdapterItem<CustomAdapterType.Tertiary, CustomAdapterModel.Tertiary>) {
        binding.data = data.dataModel.someFloat.toString()
        binding.executePendingBindings()
    }
}
