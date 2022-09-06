package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.PhotoInfoModel
import com.example.data.models.PhotoListModel
import com.example.domain.entities.PhotoInfoEntity
import com.example.domain.entities.PhotoListEntity
import javax.inject.Inject

class PhotoListMapper @Inject constructor(private val photoInfoMapper: BaseMapper<PhotoInfoModel, PhotoInfoEntity>) :
    BaseMapper<PhotoListModel, PhotoListEntity> {

    override fun map(entity: PhotoListEntity): PhotoListModel {
        TODO("Not yet implemented")
    }

    override fun map(model: PhotoListModel) = PhotoListEntity(
        data = model.data.map { photoInfoMapper.map(it) }
    )
}