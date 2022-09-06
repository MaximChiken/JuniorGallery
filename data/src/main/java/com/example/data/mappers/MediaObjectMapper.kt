package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.MediaObjectModel
import com.example.domain.entities.MediaObjectEntity
import javax.inject.Inject

class MediaObjectMapper @Inject constructor() : BaseMapper<MediaObjectModel, MediaObjectEntity> {

    override fun map(entity: MediaObjectEntity) = MediaObjectModel(
        id = entity.id,
        name = entity.name,
    )

    override fun map(model: MediaObjectModel) = MediaObjectEntity(
        id = model.id,
        name = model.name,
    )
}