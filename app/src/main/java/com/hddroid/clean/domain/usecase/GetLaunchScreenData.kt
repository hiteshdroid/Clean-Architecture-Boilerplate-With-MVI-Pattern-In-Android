package com.hddroid.clean.domain.usecase

import com.hddroid.clean.core.domain.AsyncResult
import com.hddroid.clean.core.domain.usecase.BaseUseCase
import com.hddroid.clean.domain.*
import com.hddroid.clean.domain.model.LaunchScreenExceptions
import com.hddroid.clean.domain.model.LaunchScreenParams
import com.hddroid.clean.domain.model.LaunchScreenResult
import com.hddroid.clean.domain.repository.LaunchScreenDataRepository
import com.hddroid.clean.domain.repository.TranslationsRepository

class GetLaunchScreenData(
    private val launchScreenDataRepository: LaunchScreenDataRepository,
    private val translationsRepository: TranslationsRepository
) : BaseUseCase<LaunchScreenParams, LaunchScreenResult> {

    override suspend fun invoke(requestParams: LaunchScreenParams?): LaunchScreenResult {
        return when (val result = launchScreenDataRepository.loadData(requestParams)) {
            is AsyncResult.Success -> result.value
            is AsyncResult.Failure -> createErrorResult(result.throwable)
        }
    }

    private suspend fun createErrorResult(throwable: LaunchScreenExceptions): LaunchScreenResult {
        return when (throwable) {
            LaunchScreenExceptions.DataFetchException -> {
                val fetchTranslations = translationsRepository.fetchTranslations()
                LaunchScreenResult.ErrorResult(
                    fetchTranslations[Constants.Error.Header().DATA_FETCH_ERROR],
                    fetchTranslations[Constants.Error.Title().DATA_FETCH_ERROR],
                    fetchTranslations[Constants.Error.Message().DATA_FETCH_ERROR]
                )
            }
        }
    }
}