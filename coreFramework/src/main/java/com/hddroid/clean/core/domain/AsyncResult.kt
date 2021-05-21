package com.hddroid.clean.core.domain

sealed class AsyncResult<out T : Any, out E : CustomExceptions> {
    data class Success<out T : Any>(val data: T) : AsyncResult<T, Nothing>()
    data class Failure<out E : CustomExceptions>(val exception: E) : AsyncResult<Nothing, E>()
}