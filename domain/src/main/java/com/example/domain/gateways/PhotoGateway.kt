package com.example.domain.gateways

import com.example.domain.entities.PhotoEntity
import io.reactivex.rxjava3.core.Single

interface PhotoGateway {

    fun getPhoto(new: Boolean, popular: Boolean, page: Int): Single<PhotoEntity>
}