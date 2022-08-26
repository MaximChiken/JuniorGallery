package com.example.domain.gateways

import com.example.domain.entities.LoginEntity
import com.example.domain.entities.PasswordsEntity
import com.example.domain.entities.RegistrationRequestEntity
import com.example.domain.entities.RegistrationResponseEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single


interface UserGateway {

    fun postUser(registrationRequestEntity: RegistrationRequestEntity): Single<RegistrationResponseEntity>

    fun loginUser(username: String, password: String): Single<LoginEntity>

    fun refreshAccessToken(refreshToken: String): Single<LoginEntity>

    fun getCurrentUser(): Single<RegistrationResponseEntity>

    fun getUser(id: String): Single<RegistrationResponseEntity>

    fun deleteUser(id: String): Completable

    fun updateUser(newUser: RegistrationResponseEntity): Completable

    fun updatePassword(id: String, passwords: PasswordsEntity): Completable
}