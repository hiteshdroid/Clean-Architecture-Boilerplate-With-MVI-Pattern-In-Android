package com.hddroid.clean.core.presentation.view.adapter.custom

sealed class CustomAdapterModel {
    class PrimaryModel(val someString: String): CustomAdapterModel()
    class SecondaryModel(val someInt: Int): CustomAdapterModel()
}
