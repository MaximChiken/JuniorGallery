package com.example.domain.gateways

import com.example.domain.entities.PhotoEntity
import io.reactivex.rxjava3.core.Single

interface PhotoGateway {

    fun getPhoto(new: String = "", popular: String = "", page: Int): Single<PhotoEntity>

    fun searchPhoto(name: String, new: String = "", popular: String = ""): Single<PhotoEntity>
}