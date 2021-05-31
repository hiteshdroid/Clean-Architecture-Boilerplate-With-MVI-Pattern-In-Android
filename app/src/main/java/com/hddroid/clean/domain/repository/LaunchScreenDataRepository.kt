package com.hddroid.clean.domain.repository

import com.hddroid.clean.core.domain.entity.wrapper.ResultWrapper
import com.hddroid.clean.core.domain.repository.BaseRepository
import com.hddroid.clean.domain.model.LaunchScreenExceptions
import com.hddroid.clean.domain.model.LaunchScreenResult

interface LaunchScreenDataRepository: BaseRepository {
    suspend fun loadData(): ResultWrapper<LaunchScreenResult, LaunchScreenExceptions>
}
