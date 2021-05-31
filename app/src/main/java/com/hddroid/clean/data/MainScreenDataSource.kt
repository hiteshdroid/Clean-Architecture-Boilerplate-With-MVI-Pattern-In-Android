package com.hddroid.clean.data

import com.hddroid.clean.core.domain.entity.wrapper.ResultWrapper
import com.hddroid.clean.domain.model.LaunchScreenExceptions
import com.hddroid.clean.domain.model.LaunchScreenResult
import com.hddroid.clean.domain.repository.LaunchScreenDataRepository
import kotlinx.coroutines.delay

class MainScreenDataSource: LaunchScreenDataRepository {

    override suspend fun loadData(): ResultWrapper<LaunchScreenResult, LaunchScreenExceptions> {
        delay(2000)
        return ResultWrapper.Success(LaunchScreenResult.SuccessResult("Finally, Hello World"))
    }
}