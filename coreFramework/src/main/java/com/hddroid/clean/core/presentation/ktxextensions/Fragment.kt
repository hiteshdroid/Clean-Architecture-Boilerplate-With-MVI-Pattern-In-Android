package com.hddroid.clean.core.presentation.ktxextensions

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope

fun Fragment.getViewLifeCycleOwner(): LifecycleOwner? {
    return try {
        viewLifecycleOwner
    } catch (e: IllegalStateException) {
        Log.e("getViewLifeCycleOwner()", "null viewLifecycleOwner received", e)
        null
    }
}

val Fragment.viewLifeCycleScope: LifecycleCoroutineScope?
    get() = getViewLifeCycleOwner()?.lifecycleScope

val Fragment.viewLifeCycle: Lifecycle?
    get() = getViewLifeCycleOwner()?.lifecycle