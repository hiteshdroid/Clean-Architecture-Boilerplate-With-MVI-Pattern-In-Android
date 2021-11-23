package com.hddroid.clean.core.presentation.view.adapter.base

interface AdapterItem<T, D> {
    val type: T
    val dataModel: D

    fun getViewType(viewHolderFactory: ViewHolderFactory<T, D>): Int
}