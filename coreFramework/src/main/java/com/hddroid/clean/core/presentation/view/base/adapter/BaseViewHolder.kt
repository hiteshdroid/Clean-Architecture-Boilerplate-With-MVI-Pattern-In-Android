package com.hddroid.clean.core.presentation.view.base.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<ItemType, ItemModel>(viewBinding: ViewBinding): RecyclerView.ViewHolder(viewBinding.root) {
    abstract fun bind(data: AdapterItem<ItemType, ItemModel>)
}
