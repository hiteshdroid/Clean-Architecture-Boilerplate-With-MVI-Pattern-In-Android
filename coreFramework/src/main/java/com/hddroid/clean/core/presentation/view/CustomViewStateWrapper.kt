package com.hddroid.clean.core.presentation.view

import android.os.Parcelable
import com.hddroid.clean.core.presentation.view.base.BaseViewState
import kotlinx.android.parcel.Parcelize

@Parcelize
class CustomViewStateWrapper(val superState: Parcelable?, val state: BaseViewState): Parcelable
