package com.example.data.api

import com.example.data.models.TokenResponse
import com.example.data.models.PasswordsModel
import com.example.data.models.UserModel
import com.example.data.models.RegistrationModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface UserApi {

    @POST("/api/users")
    fun createUser(@Body user: RegistrationModel): Single<RegistrationModel>

    @GET("/oauth/v2/token")
    fun loginUser(
        @Query("client_id") client_id: String = CLIENT_ID,
        @Query("grant_type") grant_type: String = GRANT_PASSWORD,
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("client_secret") client_secret: String = CLIENT_SECRET,
    ): Single<TokenResponse>

    @GET("/oauth/v2/token")
    fun refreshTokens(
        @Query("client_id") client_id: String = CLIENT_ID,
        @Query("grant_type") grant_type: String = GRANT_REFRESH,
        @Query("refresh_token") refresh_token: String,
        @Query("client_secret") client_secret: String = CLIENT_SECRET,
    ): Single<TokenResponse>

    @GET("/api/users/current")
    fun getCurrentUser(): Single<UserModel>

    @GET("/api/users/{id}")
    fun getUser(
        @Path("id") id: String
    ): Single<UserModel>

    @DELETE("/api/users/{id}")
    fun deleteUser(
        @Path("id") id: String
    ): Completable

    @PUT("/api/users/{id}")
    fun updateUser(
        @Path("id") id: String,
        @Body newUserData: UserModel
    ): Completable

    @PUT("/api/users/update_password/{id}")
    fun updatePassword(
        @Path("id") id: String,
        @Body asd: PasswordsModel
    ): Completable

    companion object{
        const val CLIENT_ID = "1_3fxvjh2ky7s44cskwcgo0k8cwwogkocs8k4cwcwsg0skcsw4ok"
        const val CLIENT_SECRET = "4tf1qez2dc4ksg8w4og4co4w40s0gokwwkwkss8gc400owkokc"
        const val GRANT_REFRESH = "refresh_token"
        const val GRANT_PASSWORD = "password"
    }
}