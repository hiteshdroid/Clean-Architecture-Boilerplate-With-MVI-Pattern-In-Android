package com.hddroid.clean.core.domain

sealed class AsyncResult<R> {
    data class Success<R>(val value: R): AsyncResult<R>()
    data class Failure<R>(val throwable: Throwable?): AsyncResult<R>()
}