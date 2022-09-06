package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.PhotoInfoModel
import com.example.domain.entities.PhotoInfoEntity
import javax.inject.Inject

class PhotoInfoMapper @Inject constructor() : BaseMapper<PhotoInfoModel, PhotoInfoEntity> {

    override fun map(entity: PhotoInfoEntity): PhotoInfoModel {
        TODO("Not yet implemented")
    }

    override fun map(model: PhotoInfoModel) = PhotoInfoEntity(
        id = model.id ?: 0,
        name = model.name ?: " ",
        date = model.date ?: " ",
        description = model.description ?: " ",
        image = model.image.photoName,
        user = model.user ?: " "
    )
}
