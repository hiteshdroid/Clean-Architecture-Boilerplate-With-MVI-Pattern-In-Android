package com.hddroid.clean.domain.model

sealed class LaunchScreenResult {
    data class SuccessResult(val screenContent: String): LaunchScreenResult()
    data class ErrorResult(val header: String?, val title: String?, val message: String?): LaunchScreenResult()
}
