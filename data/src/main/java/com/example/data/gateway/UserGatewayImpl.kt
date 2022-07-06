package com.example.data.gateway

import com.example.data.api.UserApi
import com.example.domain.UserGateway
import com.example.domain.entities.LoginResponse
import com.example.domain.entities.UserRequest
import io.reactivex.rxjava3.core.Single

class UserGatewayImpl(private val userApi: UserApi) : UserGateway {


    override fun postUser(userRequest: UserRequest): Single<UserRequest> = userApi.createUser(userRequest)

    override fun loginUser(username: String, password: String): Single<LoginResponse> =
        userApi.loginUser(CLIENT_ID, CLIENT_SECRET, username, password)

    companion object {
        const val CLIENT_ID = "3_1v7ugoq694tcow0s0w8csw0k8koo0s44swgg0w8s0kkkosgw8w"

        const val CLIENT_SECRET = "5efb9az2d1sss48sgkowsow0gowck0k0ko4kswccog440gcw8o"
    }
}