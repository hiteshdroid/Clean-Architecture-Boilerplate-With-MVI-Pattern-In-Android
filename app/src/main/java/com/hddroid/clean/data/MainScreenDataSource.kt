package com.hddroid.clean.data

import com.hddroid.clean.core.domain.AsyncResult
import com.hddroid.clean.domain.repository.LaunchScreenDataRepository
import com.hddroid.clean.domain.model.LaunchScreenExceptions
import com.hddroid.clean.domain.model.LaunchScreenParams
import com.hddroid.clean.domain.model.LaunchScreenResult
import kotlinx.coroutines.delay

class MainScreenDataSource: LaunchScreenDataRepository {

    override suspend fun loadData(): AsyncResult<LaunchScreenResult, LaunchScreenExceptions> {
        delay(2000)
        return AsyncResult.Success(LaunchScreenResult.SuccessResult("Finally, Hello World"))
    }
}