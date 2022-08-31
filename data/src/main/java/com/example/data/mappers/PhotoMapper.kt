package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.PhotoListModel
import com.example.domain.entities.PhotoInfoEntity
import com.example.domain.entities.PhotoListEntity

class PhotoMapper : BaseMapper<PhotoListModel, PhotoListEntity> {

    override fun map(entity: PhotoListEntity): PhotoListModel {
        TODO("Not yet implemented")
    }

    override fun map(model: PhotoListModel) = PhotoListEntity(
        data = model.data.map {
            PhotoInfoEntity(
                id = it.id ?: 0,
                name = it.name ?: " ",
                date = it.date ?: " ",
                description = it.description ?: " ",
                image = it.image.photoName,
                user = it.user ?: " ")
        }
    )
}