package com.example.data.gateway_impl

import com.example.data.api.PhotoApi
import com.example.data.base.BaseGateway
import com.example.data.base.BaseMapper
import com.example.data.models.PhotoModel
import com.example.domain.entities.PhotoEntity
import com.example.domain.gateways.PhotoGateway
import javax.inject.Inject

class PhotoGatewayImpl @Inject constructor(
    private val photoApi: PhotoApi,
    private val photoMapper: BaseMapper<PhotoModel, PhotoEntity>
) : PhotoGateway, BaseGateway {

    override fun getPhoto(new: Boolean, popular: Boolean, page:Int) =
        withMapper(photoMapper) {photoApi.getPhoto(new, popular, page,20)}
}
