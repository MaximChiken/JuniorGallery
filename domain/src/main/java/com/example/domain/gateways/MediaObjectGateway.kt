package com.example.domain.gateways

import com.example.domain.entities.MediaObjectEntity
import io.reactivex.rxjava3.core.Single
import okhttp3.MultipartBody

interface MediaObjectGateway {

    fun postMediaObject(image: MultipartBody.Part, name: String): Single<MediaObjectEntity>
}