package com.hddroid.clean.domain.model

import com.hddroid.clean.core.domain.CustomExceptions

sealed class LaunchScreenExceptions: CustomExceptions {
    object DataFetchException: LaunchScreenExceptions()
}