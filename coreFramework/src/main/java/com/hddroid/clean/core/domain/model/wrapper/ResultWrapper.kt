package com.hddroid.clean.core.domain.model.wrapper

sealed class ResultWrapper<T> {
    data class Success<T>(val data: T) : ResultWrapper<T>()
    data class Error<T>(val throwable: Throwable) : ResultWrapper<T>()
    data class Unknown<T>(val message: String?) : ResultWrapper<T>()
}