package com.example.data.gateway_impl

import com.example.data.api.UserApi
import com.example.data.base.BaseGateway
import com.example.data.base.BaseMapper
import com.example.data.models.LoginResponse
import com.example.data.models.RegistrationModel
import com.example.data.models.RegistrationRequestModel
import com.example.domain.entities.LoginEntity
import com.example.domain.entities.RegistrationRequestEntity
import com.example.domain.entities.RegistrationResponseEntity
import com.example.domain.gateways.UserGateway
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserGatewayImpl @Inject constructor(
    private val userApi: UserApi,
    private val registrationRequestMapper: BaseMapper<RegistrationRequestModel, RegistrationRequestEntity>,
    private val registrationResponseMapper: BaseMapper<RegistrationModel, RegistrationResponseEntity>,
    private val loginMapper: BaseMapper<LoginResponse, LoginEntity>,
) : UserGateway, BaseGateway {


    override fun postUser(registrationRequestEntity: RegistrationRequestEntity) =
        withMapper(registrationResponseMapper) {
            userApi.createUser(registrationRequestMapper.map(registrationRequestEntity))
        }

    override fun loginUser(username: String, password: String) =
        withMapper(loginMapper) { userApi.loginUser(username = username, password = password) }

    override fun refreshAccessToken(refreshToken: String) =
        withMapper(loginMapper) { userApi.refreshTokens(refresh_token = refreshToken) }

    override fun getCurrentUser(): Single<RegistrationResponseEntity> =
        withMapper(registrationResponseMapper) { userApi.getCurrentUser() }

    override fun getUser(id: String): Single<RegistrationResponseEntity> =
        withMapper(registrationResponseMapper) { userApi.getUser(id) }
}