package com.hddroid.clean.core.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UseCaseHandler<P : UseCaseParams, R : UseCaseResult>(private val dispatcher: CoroutineDispatcher = Dispatchers.Default) {
    suspend fun execute(useCase: BaseUseCase<P, R>, params: P): R = withContext(dispatcher) {
        useCase(params)
    }
}