package com.hddroid.clean.core.domain

sealed class AsyncResult<R, E> {
    data class Success<R, E>(val value: R): AsyncResult<R, E>()
    data class Failure<R, E>(val throwable: E): AsyncResult<R, E>()
}