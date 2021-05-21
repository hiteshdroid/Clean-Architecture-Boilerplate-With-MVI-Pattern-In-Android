package com.hddroid.clean.core.presentation.ktxextensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observeSafely(owner: LifecycleOwner?, observer: Observer<T>) {
    owner?.let {
        observe(it, observer)
    }
}

fun <T> LiveData<T>.removeObserversSafely(owner: LifecycleOwner?) {
    owner?.let { removeObservers(it) }
}