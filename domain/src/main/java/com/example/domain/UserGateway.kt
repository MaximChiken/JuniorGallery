package com.example.domain

import com.example.domain.entities.LoginResponse
import com.example.domain.entities.UserRequest
import io.reactivex.rxjava3.core.Single


interface UserGateway {

    fun postUser(userRequest: UserRequest): Single<UserRequest>

    fun loginUser(username: String, password: String): Single<LoginResponse>
}