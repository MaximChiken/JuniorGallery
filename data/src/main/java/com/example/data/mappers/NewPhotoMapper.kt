package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.NewPhotoModel
import com.example.domain.entities.NewPhotoEntity
import javax.inject.Inject

class NewPhotoMapper @Inject constructor() : BaseMapper<NewPhotoModel, NewPhotoEntity> {

    override fun map(model: NewPhotoModel): NewPhotoEntity {
        TODO("Not yet implemented")
    }

    override fun map(entity: NewPhotoEntity) = NewPhotoModel(
        name = entity.name,
        description = entity.description,
        new = entity.new,
        popular = entity.popular,
        image = "/api/media_objects/${entity.image}"
    )
}