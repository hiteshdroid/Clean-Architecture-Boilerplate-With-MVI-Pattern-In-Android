package com.hddroid.clean.domain.model

import com.hddroid.clean.core.domain.entity.CustomException

sealed class LaunchScreenExceptions: CustomException {
    object DataFetchException: LaunchScreenExceptions()
}