package com.hddroid.clean.domain.model

import com.hddroid.clean.core.domain.usecase.UseCaseResult

sealed class LaunchScreenResult : UseCaseResult {
    data class SuccessResult(val screenContent: String): LaunchScreenResult()
    data class ErrorResult(val header: String?, val title: String?, val message: String?): LaunchScreenResult()
}
