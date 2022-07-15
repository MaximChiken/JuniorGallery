package com.example.domain

import com.example.domain.core.BaseGateway
import com.example.domain.entities.*
import io.reactivex.rxjava3.core.Single


interface UserGateway: BaseGateway {

    fun postUser(registrationRequest: UserFullInfoEntity): Single<UserIdEntity>

    fun loginUser(loginRequest: UserInfoEntity): Single<TokenEntity>
}