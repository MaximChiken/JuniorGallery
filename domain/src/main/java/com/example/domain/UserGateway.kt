package com.example.domain

import com.example.domain.entities.LoginResponse
import com.example.domain.entities.RegistrationResponse
import com.example.domain.entities.RegistrationRequest
import io.reactivex.rxjava3.core.Single


interface UserGateway {

    fun postUser(userRequest: RegistrationRequest): Single<RegistrationResponse>

    fun loginUser(username: String, password: String): Single<LoginResponse>
}