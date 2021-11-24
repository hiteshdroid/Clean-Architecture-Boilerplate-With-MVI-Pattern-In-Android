package com.hddroid.clean.presentation.view.adapter.custom

import com.hddroid.clean.core.presentation.view.base.adapter.AdapterItem
import com.hddroid.clean.core.presentation.view.base.adapter.BaseViewHolder
import com.hddroid.clean.databinding.PrimaryBinding

class PrimaryViewHolder(private val binding: PrimaryBinding): BaseViewHolder<CustomAdapterType.Primary, CustomAdapterModel.Primary>(binding) {
    override fun bind(data: AdapterItem<CustomAdapterType.Primary, CustomAdapterModel.Primary>) {
        binding.data = data.dataModel.someString
        binding.executePendingBindings()
    }
}
