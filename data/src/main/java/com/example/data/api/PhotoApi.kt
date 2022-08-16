package com.example.data.api

import com.example.data.models.PhotoModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoApi {

    @GET("/api/photos")
    fun getPhoto(
        @Query("new") new: Boolean,
        @Query("popular") popular: Boolean,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Single<PhotoModel>
}