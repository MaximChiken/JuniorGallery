package com.example.data.gateway_impl

import com.example.data.api.PhotoApi
import com.example.data.base.BaseGateway
import com.example.data.base.BaseMapper
import com.example.data.models.NewPhotoModel
import com.example.data.models.PhotoInfoModel
import com.example.data.models.PhotoListModel
import com.example.domain.entities.NewPhotoEntity
import com.example.domain.entities.PhotoInfoEntity
import com.example.domain.entities.PhotoListEntity
import com.example.domain.gateways.PhotoGateway
import javax.inject.Inject

class PhotoGatewayImpl @Inject constructor(
    private val photoApi: PhotoApi,
    private val photoMapper: BaseMapper<PhotoListModel, PhotoListEntity>,
    private val newPhotoMapper: BaseMapper<NewPhotoModel, NewPhotoEntity>,
    private val photoInfoMapper: BaseMapper<PhotoInfoModel, PhotoInfoEntity>,
) : PhotoGateway, BaseGateway {

    override fun getPhoto(new: String, popular: String, page: Int) =
        withMapper(photoMapper) { photoApi.getPhoto(new = new, popular = popular, page = page) }

    override fun searchPhoto(name: String, new: String, popular: String) =
        withMapper(photoMapper) { photoApi.getPhoto(name = name, new = new, popular = popular) }

    override fun getUserPhoto(page: Int, userId: String) =
        withMapper(photoMapper) { photoApi.getPhoto(page = page, userId = userId) }

    override fun postPhoto(newPhotoEntity: NewPhotoEntity) =
        withMapper(photoInfoMapper) { photoApi.postPhoto(newPhotoMapper.map(newPhotoEntity)) }
}
