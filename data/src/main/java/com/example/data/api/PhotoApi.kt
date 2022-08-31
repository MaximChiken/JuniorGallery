package com.example.data.api

import com.example.data.models.PhotoListModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
interface PhotoApi {

    @GET("/api/photos")
    fun getPhoto(
        @Query("new") new: String = "",
        @Query("popular") popular: String = "",
        @Query("name") name: String = "",
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20,
    ): Single<PhotoListModel>

//    @POST("/api/photo")
//    fun postPhoto(
//        @Query("name") name: String,
//        @Query("dateCreate") dateCreate: String,
//        @Query("description") description: String,
//        @Query("new") isNew: Boolean,
//        @Query("popular") isPopular: Boolean,
//        @Query("image") image: {}
//    )
}

