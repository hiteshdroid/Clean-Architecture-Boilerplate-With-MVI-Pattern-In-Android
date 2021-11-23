package com.hddroid.clean.core.presentation.view.adapter.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<ItemType, ItemModel>(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(data: AdapterItem<ItemType, ItemModel>)
}
