package com.hddroid.clean.core.presentation.view.base.adapter

import android.view.ViewGroup

interface ViewHolderFactory<AdapterType, DataModel> {
    fun getViewType(item: AdapterItem<AdapterType, DataModel>): Int
    fun createViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<AdapterType, DataModel>
}
