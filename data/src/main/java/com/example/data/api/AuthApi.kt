package com.example.data.api

import com.example.data.models.RegistrationModel
import com.example.data.models.TokenResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {

    @POST("/api/users")
    fun createUser(@Body user: RegistrationModel): Single<RegistrationModel>

    @GET("/oauth/v2/token")
    fun loginUser(
        @Query("client_id") client_id: String = UserApi.CLIENT_ID,
        @Query("grant_type") grant_type: String = UserApi.GRANT_PASSWORD,
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("client_secret") client_secret: String = UserApi.CLIENT_SECRET,
    ): Single<TokenResponse>

    @GET("/oauth/v2/token")
    fun refreshTokens(
        @Query("client_id") client_id: String = UserApi.CLIENT_ID,
        @Query("grant_type") grant_type: String = UserApi.GRANT_REFRESH,
        @Query("refresh_token") refresh_token: String,
        @Query("client_secret") client_secret: String = UserApi.CLIENT_SECRET,
    ): Single<TokenResponse>
}