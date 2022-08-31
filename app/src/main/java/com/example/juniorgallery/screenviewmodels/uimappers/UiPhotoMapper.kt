package com.example.juniorgallery.screenviewmodels.uimappers

import com.example.domain.entities.PhotoListEntity
import com.example.juniorgallery.base.BaseUiMapper
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel
import com.example.juniorgallery.screenviewmodels.PhotoListScreenModel

class UiPhotoMapper : BaseUiMapper<PhotoListScreenModel, PhotoListEntity> {
    override fun map(model: PhotoListScreenModel): PhotoListEntity {
        TODO("Not yet implemented")
    }

    override fun map(entity: PhotoListEntity) = PhotoListScreenModel(
        data = entity.data.map {
            PhotoInfoScreenModel(
                id = it.id,
                name = it.name,
                date = it.date,
                description = it.description,
                image = it.image,
                user = it.user
            )
        }
    )
}