package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.PhotoModel
import com.example.domain.entities.ImageNameEntity
import com.example.domain.entities.PhotoEntity
import com.example.domain.entities.PhotoInfoEntity

class PhotoMapper : BaseMapper<PhotoModel, PhotoEntity> {

    override fun map(entity: PhotoEntity): PhotoModel {
        TODO("Not yet implemented")
    }

    override fun map(model: PhotoModel) = PhotoEntity(
        data = model.data.map {
            PhotoInfoEntity(
                id = it.id ?: 0,
                name = it.name ?: " ",
                date = it.date ?: " ",
                description = it.description ?: " ",
                image = ImageNameEntity(it.image.name),
                user = it.user ?: " ")
        }
    )
}