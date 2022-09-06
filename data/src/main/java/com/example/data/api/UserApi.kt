package com.example.data.api

import com.example.data.models.PasswordsModel
import com.example.data.models.UserModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface UserApi {

    @GET("/api/users/current")
    fun getCurrentUser(): Single<UserModel>

    @GET("/api/users/{id}")
    fun getUser(
        @Path("id") id: String,
    ): Single<UserModel>

    @DELETE("/api/users/{id}")
    fun deleteUser(
        @Path("id") id: String,
    ): Completable

    @PUT("/api/users/{id}")
    fun updateUser(
        @Path("id") id: String,
        @Body newUserData: UserModel,
    ): Completable

    @PUT("/api/users/update_password/{id}")
    fun updatePassword(
        @Path("id") id: String,
        @Body asd: PasswordsModel,
    ): Completable

    companion object {
        const val CLIENT_ID = "1_3fxvjh2ky7s44cskwcgo0k8cwwogkocs8k4cwcwsg0skcsw4ok"
        const val CLIENT_SECRET = "4tf1qez2dc4ksg8w4og4co4w40s0gokwwkwkss8gc400owkokc"
        const val GRANT_REFRESH = "refresh_token"
        const val GRANT_PASSWORD = "password"
    }
}