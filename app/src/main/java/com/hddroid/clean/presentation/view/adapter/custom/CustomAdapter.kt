package com.hddroid.clean.presentation.view.adapter.custom

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hddroid.clean.core.presentation.view.base.adapter.BaseViewHolder

class CustomAdapter(
    private val viewHolderFactory: CustomViewHolderFactory
) : RecyclerView.Adapter<BaseViewHolder<CustomAdapterType, CustomAdapterModel>>() {
    private var list: MutableList<CustomAdapterItem> = mutableListOf()

    fun setData(list: MutableList<CustomAdapterItem>) {
        this.list = list
    }

    override fun getItemViewType(position: Int): Int {
        return viewHolderFactory.getViewType(this.list[position])
    }

    override fun getItemCount() = this.list.size

    override fun onBindViewHolder(
        holder: BaseViewHolder<CustomAdapterType, CustomAdapterModel>,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<CustomAdapterType, CustomAdapterModel> {
        return viewHolderFactory.createViewHolder(parent, viewType)
    }
}