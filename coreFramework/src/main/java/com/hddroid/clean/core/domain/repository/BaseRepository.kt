package com.hddroid.clean.core.domain.repository
import com.hddroid.clean.core.domain.model.BaseDomainModel
import com.hddroid.clean.core.domain.model.wrapper.ResultWrapper

interface BaseRepository<Entity: BaseDomainModel> {
    suspend operator fun invoke(): ResultWrapper<Entity>
}