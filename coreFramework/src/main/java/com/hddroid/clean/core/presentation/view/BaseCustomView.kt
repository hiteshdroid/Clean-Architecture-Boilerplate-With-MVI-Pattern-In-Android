package com.hddroid.clean.core.presentation.view

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.view.View
import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleOwner
import com.hddroid.clean.core.presentation.view.base.BaseView
import com.hddroid.clean.core.presentation.view.base.BaseViewState
import com.hddroid.clean.core.presentation.viewmodel.BaseStateViewModel

abstract class BaseCustomView<VS: BaseViewState, VM : BaseStateViewModel<VS>> @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr), BaseView<VS, VM> {

    @CallSuper
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val lifecycleOwner = context as? LifecycleOwner ?: throw LifecycleOwnerNotFoundException()
        onLifecycleOwnerAttached(lifecycleOwner)
    }

    override fun onSaveInstanceState(): Parcelable? {
        try {
            val currentState = getViewModel().getCurrentState()
            CustomViewStateWrapper(super.onSaveInstanceState(), currentState)
        } catch (e: UninitializedPropertyAccessException) {
            // no previous state found.
        }

        return super.onSaveInstanceState()
    }

    @Suppress("UNCHECKED_CAST")
    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state is CustomViewStateWrapper) {
            getViewModel().setCurrentState(state.state as VS)
            super.onRestoreInstanceState(state.superState)
        }
    }
}