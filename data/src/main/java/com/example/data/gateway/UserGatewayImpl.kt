package com.example.data.gateway

import com.example.data.api.UserApi
import com.example.domain.UserGateway
import com.example.domain.entities.LoginResponse
import com.example.domain.entities.RegistrationRequest
import com.example.domain.entities.RegistrationResponse
import io.reactivex.rxjava3.core.Single

class UserGatewayImpl(private val userApi: UserApi) : UserGateway {


    override fun postUser(userRequest: RegistrationRequest): Single<RegistrationResponse> = userApi.createUser(userRequest)

    override fun loginUser(username: String, password: String): Single<LoginResponse> =
        userApi.loginUser(CLIENT_ID, CLIENT_SECRET, username, password)

    companion object {
        const val CLIENT_ID = "11_1470ty4w4deok4wsg4wkwo48c80ooocgo448k8000ggc0oocks"

        const val CLIENT_SECRET = "3mx3gazmepes0os4488wgw084cos8gwok4sswk0gsc80cskw8k"
    }
}