package com.hddroid.clean.core.domain.usecase

abstract class BaseUseCaseWithParams<P: UseCaseParams, R: UseCaseResult>: BaseUseCase<R>() {
   final override suspend fun invoke(): R {
      return invoke(getRequestParams())
   }

   abstract fun getRequestParams(): P

   abstract suspend fun invoke(params: P): R
}
