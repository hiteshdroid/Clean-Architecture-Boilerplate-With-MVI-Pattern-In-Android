package com.hddroid.clean.core.domain.usecase

abstract class BaseUseCase<R: UseCaseResult> {
    abstract suspend fun invoke(): R
}