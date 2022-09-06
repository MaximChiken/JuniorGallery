package com.example.domain.gateways

import com.example.domain.entities.RegistrationEntity
import com.example.domain.entities.TokenEntity
import io.reactivex.rxjava3.core.Single

interface AuthGateway {

    fun postUser(registrationEntity: RegistrationEntity): Single<RegistrationEntity>

    fun loginUser(username: String, password: String): Single<TokenEntity>

    fun refreshAccessToken(refreshToken: String): Single<TokenEntity>
}