package com.hddroid.clean.core.domain.usecase

import com.hddroid.clean.core.domain.AsyncResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UseCaseHandler<P : UseCaseParams, R : UseCaseResult>(private val dispatcher: CoroutineDispatcher = Dispatchers.Default) {
    suspend fun execute(useCase: BaseUseCase<P, R>, params: P): AsyncResult<R> = withContext(dispatcher) {
        useCase(params)
    }
}