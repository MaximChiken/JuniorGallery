package com.example.juniorgallery.screenviewmodels.uimappers

import com.example.domain.entities.PhotoInfoEntity
import com.example.domain.entities.PhotoListEntity
import com.example.juniorgallery.base.BaseUiMapper
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel
import com.example.juniorgallery.screenviewmodels.PhotoListScreenModel
import javax.inject.Inject

class UiPhotoListMapper @Inject constructor(
    private val uiPhotoInfoMapper: BaseUiMapper<PhotoInfoScreenModel, PhotoInfoEntity>,
) : BaseUiMapper<PhotoListScreenModel, PhotoListEntity> {

    override fun map(model: PhotoListScreenModel): PhotoListEntity {
        TODO("Not yet implemented")
    }

    override fun map(entity: PhotoListEntity) = PhotoListScreenModel(
        data = entity.data.map { uiPhotoInfoMapper.map(it) }
    )
}