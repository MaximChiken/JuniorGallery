package com.example.data.gateway_impl

import com.example.data.api.MediaObjectApi
import com.example.data.base.BaseGateway
import com.example.data.base.BaseMapper
import com.example.data.models.MediaObjectModel
import com.example.domain.entities.MediaObjectEntity
import com.example.domain.gateways.MediaObjectGateway
import okhttp3.MultipartBody
import javax.inject.Inject

class MediaObjectGatewayImpl @Inject constructor(
    private val mediaObjectApi: MediaObjectApi,
    private val mediaObjectMapper: BaseMapper<MediaObjectModel, MediaObjectEntity>,
) : MediaObjectGateway, BaseGateway {

    override fun postMediaObject(image: MultipartBody.Part, name: String) =
        withMapper(mediaObjectMapper) { mediaObjectApi.postMediaObject(image, name) }
}