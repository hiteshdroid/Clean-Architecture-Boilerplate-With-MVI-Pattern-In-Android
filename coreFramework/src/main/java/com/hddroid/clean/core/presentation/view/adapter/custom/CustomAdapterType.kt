package com.hddroid.clean.core.presentation.view.adapter.custom

sealed class CustomAdapterType {
    object Primary: CustomAdapterType()
    object Secondary: CustomAdapterType()
}
