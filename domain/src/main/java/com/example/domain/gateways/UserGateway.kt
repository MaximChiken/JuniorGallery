package com.example.domain.gateways

import com.example.domain.entities.TokenEntity
import com.example.domain.entities.PasswordsEntity
import com.example.domain.entities.RegistrationEntity
import com.example.domain.entities.UserEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single


interface UserGateway {

    fun postUser(registrationEntity: RegistrationEntity): Single<RegistrationEntity>

    fun loginUser(username: String, password: String): Single<TokenEntity>

    fun refreshAccessToken(refreshToken: String): Single<TokenEntity>

    fun getCurrentUser(): Single<UserEntity>

    fun getUser(id: String): Single<UserEntity>

    fun deleteUser(id: String): Completable

    fun updateUser(newUser: UserEntity): Completable

    fun updatePassword(id: String, passwords: PasswordsEntity): Completable
}