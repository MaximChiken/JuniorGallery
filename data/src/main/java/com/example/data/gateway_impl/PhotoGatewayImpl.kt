package com.example.data.gateway_impl

import com.example.data.api.PhotoApi
import com.example.data.base.BaseGateway
import com.example.data.base.BaseMapper
import com.example.data.models.PhotoListModel
import com.example.domain.entities.PhotoListEntity
import com.example.domain.gateways.PhotoGateway
import javax.inject.Inject

class PhotoGatewayImpl @Inject constructor(
    private val photoApi: PhotoApi,
    private val photoMapper: BaseMapper<PhotoListModel, PhotoListEntity>,
) : PhotoGateway, BaseGateway {

    override fun getPhoto(new: String, popular: String, page: Int) =
        withMapper(photoMapper) { photoApi.getPhoto(new = new, popular = popular, page = page) }

    override fun searchPhoto(name: String, new: String, popular: String) =
        withMapper(photoMapper) { photoApi.getPhoto(name = name, new = new, popular = popular) }
}
