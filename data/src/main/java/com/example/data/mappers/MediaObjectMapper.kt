package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.MediaObjectModel
import com.example.domain.entities.MediaObjectEntity

class MediaObjectMapper:BaseMapper<MediaObjectModel, MediaObjectEntity> {

    override fun map(entity: MediaObjectEntity) =MediaObjectModel(
        entity.file,
        entity.name
    )

    override fun map(model: MediaObjectModel): MediaObjectEntity {
        TODO("Not yet implemented")
    }
}