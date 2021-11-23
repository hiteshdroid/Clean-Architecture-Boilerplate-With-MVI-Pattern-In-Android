package com.hddroid.clean.core.presentation.view.adapter.custom

import android.view.View
import android.widget.TextView
import com.hddroid.clean.core.R
import com.hddroid.clean.core.presentation.view.adapter.base.AdapterItem
import com.hddroid.clean.core.presentation.view.adapter.base.BaseViewHolder

class SecondaryViewHolder(view: View): BaseViewHolder<CustomAdapterType.Secondary, CustomAdapterModel.SecondaryModel>(view) {
    private val numberView = view.findViewById<TextView>(R.id.numberView)
    override fun bind(data: AdapterItem<CustomAdapterType.Secondary, CustomAdapterModel.SecondaryModel>) {
        numberView.text = data.dataModel.someInt.toString()
    }
}
