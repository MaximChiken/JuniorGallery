package com.example.data.gateway_impl

import com.example.data.api.AuthApi
import com.example.data.base.BaseGateway
import com.example.data.base.BaseMapper
import com.example.data.models.RegistrationModel
import com.example.data.models.TokenResponse
import com.example.domain.entities.RegistrationEntity
import com.example.domain.entities.TokenEntity
import com.example.domain.gateways.AuthGateway
import javax.inject.Inject

class AuthGatewayImpl @Inject constructor(
    private val authApi: AuthApi,
    private val registrationMapper: BaseMapper<RegistrationModel, RegistrationEntity>,
    private val tokenMapper: BaseMapper<TokenResponse, TokenEntity>,
) : BaseGateway, AuthGateway {

    override fun postUser(registrationEntity: RegistrationEntity) =
        withMapper(registrationMapper) { authApi.createUser(registrationMapper.map(registrationEntity)) }

    override fun loginUser(username: String, password: String) =
        withMapper(tokenMapper) { authApi.loginUser(username = username, password = password) }

    override fun refreshAccessToken(refreshToken: String) =
        withMapper(tokenMapper) { authApi.refreshTokens(refresh_token = refreshToken) }
}