package com.hddroid.clean.core.domain.usecase

import com.hddroid.clean.core.domain.usecase.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UseCaseHandler(private val dispatcher: CoroutineDispatcher = Dispatchers.Default) {
    suspend fun <Result> execute(useCase: BaseUseCase<Result>): Result = withContext(dispatcher) {
        useCase.invoke()
    }
}