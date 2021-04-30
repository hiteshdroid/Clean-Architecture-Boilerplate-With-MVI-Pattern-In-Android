package com.hddroid.clean.core.data.repository

import com.hddroid.clean.core.data.model.BaseDataModel
import com.hddroid.clean.core.domain.model.BaseDomainModel
import com.hddroid.clean.core.domain.repository.BaseRepository

abstract class BaseRepositoryImpl<Entity: BaseDomainModel, DataModel: BaseDataModel> : BaseRepository<Entity> {
    abstract fun mapDataModelToEntity(dataModel: DataModel): Entity
}