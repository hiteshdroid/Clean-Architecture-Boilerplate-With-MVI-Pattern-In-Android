package com.hddroid.clean.core.domain.usecase

interface BaseUseCase<P: UseCaseParams, R: UseCaseResult> {
   suspend operator fun invoke(requestParams: P? = null): R
}
