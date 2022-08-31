package com.example.domain.gateways

import io.reactivex.rxjava3.core.Completable
import okhttp3.MultipartBody

interface MediaObjectGateway {

    fun postMediaObject(image: MultipartBody.Part, name: String): Completable
}