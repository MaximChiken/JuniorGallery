package com.example.data.api

import com.example.data.models.LoginResponse
import com.example.data.models.RegistrationRequestModel
import com.example.data.models.RegistrationModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {

    @POST("/api/users")
    fun createUser(@Body user: RegistrationRequestModel): Single<RegistrationModel>

    @GET("/oauth/v2/token")
    fun loginUser(
        @Query("client_id") client_id: String = "1_3fxvjh2ky7s44cskwcgo0k8cwwogkocs8k4cwcwsg0skcsw4ok",
        @Query("grant_type") grant_type: String = "password",
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("client_secret") client_secret: String = "4tf1qez2dc4ksg8w4og4co4w40s0gokwwkwkss8gc400owkokc",
    ): Single<LoginResponse>
}