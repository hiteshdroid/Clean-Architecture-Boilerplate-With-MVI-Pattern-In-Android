package com.hddroid.clean.core.domain.usecase

abstract class BaseUseCaseWithParams<Params, out Result>: BaseUseCase<Result>() {
   final override suspend fun invoke(): Result {
      return invoke(getRequestParams())
   }

   abstract fun getRequestParams(): Params

   abstract suspend fun invoke(params: Params): Result
}
