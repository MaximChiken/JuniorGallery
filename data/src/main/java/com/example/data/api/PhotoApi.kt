package com.example.data.api

import com.example.data.models.NewPhotoModel
import com.example.data.models.PhotoInfoModel
import com.example.data.models.PhotoListModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PhotoApi {

    @GET("/api/photos")
    fun getPhoto(
        @Query("user.id") userId: String = "",
        @Query("new") new: String = "",
        @Query("popular") popular: String = "",
        @Query("name") name: String = "",
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20,
    ): Single<PhotoListModel>

    @POST("/api/photos")
    fun postPhoto(@Body newPhotoModel: NewPhotoModel): Single<PhotoInfoModel>
}

