package com.hddroid.clean.core.presentation.view.adapter.custom

sealed class CustomAdapterModel {
    class Primary(val someString: String): CustomAdapterModel()
    class Secondary(val someInt: Int): CustomAdapterModel()
    class Tertiary(val someFloat: Float): CustomAdapterModel()
}
