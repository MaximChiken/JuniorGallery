package com.example.domain.gateways

import com.example.domain.entities.PhotoListEntity
import io.reactivex.rxjava3.core.Single

interface PhotoGateway {

    fun getPhoto(new: String = "", popular: String = "", page: Int): Single<PhotoListEntity>

    fun searchPhoto(name: String, new: String = "", popular: String = ""): Single<PhotoListEntity>
}