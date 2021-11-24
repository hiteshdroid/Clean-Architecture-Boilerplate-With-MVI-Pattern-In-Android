package com.hddroid.clean.core.presentation.view.adapter.custom

import android.view.View
import android.widget.TextView
import com.hddroid.clean.core.R
import com.hddroid.clean.core.presentation.view.adapter.base.AdapterItem
import com.hddroid.clean.core.presentation.view.adapter.base.BaseViewHolder

class TertiaryViewHolder(view: View): BaseViewHolder<CustomAdapterType.Tertiary, CustomAdapterModel.Tertiary>(view) {
    private val numberView = view.findViewById<TextView>(R.id.floatView)
    override fun bind(data: AdapterItem<CustomAdapterType.Tertiary, CustomAdapterModel.Tertiary>) {
        numberView.text = data.dataModel.someFloat.toString()
    }
}
