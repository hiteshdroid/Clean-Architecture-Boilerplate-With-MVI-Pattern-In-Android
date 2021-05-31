package com.hddroid.clean.core.domain.usecase

abstract class BaseUseCase<out Result> {
    abstract suspend fun invoke(): Result
}