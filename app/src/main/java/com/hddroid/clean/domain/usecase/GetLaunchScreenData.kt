package com.hddroid.clean.domain.usecase

import com.hddroid.clean.core.domain.entity.wrapper.ResultWrapper
import com.hddroid.clean.core.domain.usecase.BaseUseCase
import com.hddroid.clean.domain.Constants
import com.hddroid.clean.domain.model.LaunchScreenExceptions
import com.hddroid.clean.domain.model.LaunchScreenResult
import com.hddroid.clean.domain.repository.LaunchScreenDataRepository
import com.hddroid.clean.domain.repository.TranslationsRepository

class GetLaunchScreenData(
    private val launchScreenDataRepository: LaunchScreenDataRepository,
    private val translationsRepository: TranslationsRepository
) : BaseUseCase<LaunchScreenResult>() {

    override suspend fun invoke(): LaunchScreenResult {
        return when (val result = launchScreenDataRepository.loadData()) {
            is ResultWrapper.Success -> result.data
            is ResultWrapper.Failure -> createErrorResult(result.exception)
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