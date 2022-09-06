package com.example.juniorgallery.screenviewmodels.uimappers

import com.example.domain.entities.PhotoInfoEntity
import com.example.juniorgallery.base.BaseUiMapper
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel
import javax.inject.Inject

class UiPhotoInfoMapper @Inject constructor() : BaseUiMapper<PhotoInfoScreenModel, PhotoInfoEntity> {

    override fun map(model: PhotoInfoScreenModel): PhotoInfoEntity {
        TODO("Not yet implemented")
    }

    override fun map(entity: PhotoInfoEntity) = PhotoInfoScreenModel(
        id = entity.id,
        name = entity.name,
        date = entity.date,
        description = entity.description,
        image = entity.image,
        user = entity.user
    )
}