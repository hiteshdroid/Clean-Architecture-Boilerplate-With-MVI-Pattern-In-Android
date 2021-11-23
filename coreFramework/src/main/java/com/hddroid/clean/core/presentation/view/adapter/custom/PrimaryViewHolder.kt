package com.hddroid.clean.core.presentation.view.adapter.custom

import android.view.View
import android.widget.TextView
import com.hddroid.clean.core.R
import com.hddroid.clean.core.presentation.view.adapter.base.AdapterItem
import com.hddroid.clean.core.presentation.view.adapter.base.BaseViewHolder

class PrimaryViewHolder(view: View): BaseViewHolder<CustomAdapterType.Primary, CustomAdapterModel.PrimaryModel>(view) {
    private val textView = view.findViewById<TextView>(R.id.titleView)
    override fun bind(data: AdapterItem<CustomAdapterType.Primary, CustomAdapterModel.PrimaryModel>) {
        textView.text = data.dataModel.someString
    }
}
