package com.example.domain.gateways

import com.example.domain.entities.NewPhotoEntity
import com.example.domain.entities.PhotoInfoEntity
import com.example.domain.entities.PhotoListEntity
import io.reactivex.rxjava3.core.Single

interface PhotoGateway {

    fun getPhoto(new: String = "", popular: String = "", page: Int): Single<PhotoListEntity>

    fun searchPhoto(name: String, new: String = "", popular: String = ""): Single<PhotoListEntity>

    fun getUserPhoto(page: Int, userId: String): Single<PhotoListEntity>

    fun postPhoto(newPhotoEntity: NewPhotoEntity): Single<PhotoInfoEntity>
}