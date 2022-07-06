package com.example.data.api

import com.example.domain.entities.LoginResponse
import com.example.domain.entities.UserRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {

    @POST("/api/users")
    fun createUser(@Body user: UserRequest): Single<UserRequest>

    @GET("/oauth/v2/token")
    fun loginUser(
        @Query("client_id") client_id: String,
        @Query("client_secret") client_secret: String,
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("grant_type") grant_type: String = "password"
    ): Single<LoginResponse>
}