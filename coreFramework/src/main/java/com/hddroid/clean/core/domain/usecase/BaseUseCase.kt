package com.hddroid.clean.core.domain.usecase

import com.hddroid.clean.core.domain.AsyncResult

interface BaseUseCase<P: UseCaseParams, R: UseCaseResult> {
   suspend operator fun invoke(requestParams: P? = null): AsyncResult<R>
}
