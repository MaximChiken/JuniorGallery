package com.example.data.gateway

import com.example.data.api.UserApi
import com.example.data.models.RegistrationRequest
import com.example.data.models.RegistrationResponse
import com.example.domain.UserGateway
import com.example.domain.core.Mapper
import com.example.domain.entities.TokenEntity
import com.example.domain.entities.UserFullInfoEntity
import com.example.domain.entities.UserIdEntity
import com.example.domain.entities.UserInfoEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserGatewayImpl<R : Any> @Inject constructor(
    private val userApi: UserApi,
    private val toRegistrationDomainMapper: Mapper<RegistrationResponse, UserIdEntity>,
    private val toRegistrationRequestMapper: Mapper<UserFullInfoEntity, RegistrationRequest>,
) : UserGateway<R> {


    override fun postUser(registrationRequest: UserFullInfoEntity): Single<UserIdEntity> =
        userApi.createUser(toRegistrationRequestMapper.map(registrationRequest))
            .map { it.let(toRegistrationDomainMapper::map) }


    override fun loginUser(loginRequest: UserInfoEntity): Single<TokenEntity> =
        userApi.loginUser(CLIENT_ID, CLIENT_SECRET, loginRequest.username, loginRequest.password)


    companion object {
        const val CLIENT_ID = "11_1470ty4w4deok4wsg4wkwo48c80ooocgo448k8000ggc0oocks"

        const val CLIENT_SECRET = "3mx3gazmepes0os4488wgw084cos8gwok4sswk0gsc80cskw8k"
    }


}