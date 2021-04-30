package com.hddroid.clean.core.domain.usecase

import com.hddroid.clean.core.domain.model.BaseDomainModel
import com.hddroid.clean.core.domain.model.wrapper.ResultWrapper
import com.hddroid.clean.core.domain.repository.BaseRepository

abstract class BaseUseCase<Entity: BaseDomainModel, Repository: BaseRepository<Entity>> {

    abstract val repository: Repository

    suspend operator fun invoke() : ResultWrapper<Entity> {
        return repository.invoke()
    }
}