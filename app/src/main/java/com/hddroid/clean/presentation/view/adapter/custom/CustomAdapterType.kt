package com.hddroid.clean.presentation.view.adapter.custom

sealed class CustomAdapterType {
    object Primary: CustomAdapterType()
    object Secondary: CustomAdapterType()
    object Tertiary: CustomAdapterType()
}
