package com.example.domain.gateways

import com.example.domain.entities.PasswordsEntity
import com.example.domain.entities.UserEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single


interface UserGateway {

    fun getCurrentUser(): Single<UserEntity>

    fun getUser(id: String): Single<UserEntity>

    fun deleteUser(id: String): Completable

    fun updateUser(newUser: UserEntity): Completable

    fun updatePassword(id: String, passwords: PasswordsEntity): Completable
}