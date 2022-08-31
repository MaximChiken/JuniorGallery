package com.example.data.gateway_impl

import com.example.data.api.UserApi
import com.example.data.base.BaseGateway
import com.example.data.base.BaseMapper
import com.example.data.models.PasswordsModel
import com.example.data.models.RegistrationModel
import com.example.data.models.TokenResponse
import com.example.data.models.UserModel
import com.example.domain.entities.PasswordsEntity
import com.example.domain.entities.RegistrationEntity
import com.example.domain.entities.TokenEntity
import com.example.domain.entities.UserEntity
import com.example.domain.gateways.UserGateway
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserGatewayImpl @Inject constructor(
    private val userApi: UserApi,
    private val registrationMapper: BaseMapper<RegistrationModel, RegistrationEntity>,
    private val userMapper: BaseMapper<UserModel, UserEntity>,
    private val loginMapper: BaseMapper<TokenResponse, TokenEntity>,
    private val passwordsMapper: BaseMapper<PasswordsModel, PasswordsEntity>,
) : UserGateway, BaseGateway {


    override fun postUser(registrationEntity: RegistrationEntity) =
        withMapper(registrationMapper) { userApi.createUser(registrationMapper.map(registrationEntity)) }

    override fun loginUser(username: String, password: String) =
        withMapper(loginMapper) { userApi.loginUser(username = username, password = password) }

    override fun refreshAccessToken(refreshToken: String) =
        withMapper(loginMapper) { userApi.refreshTokens(refresh_token = refreshToken) }

    override fun getCurrentUser(): Single<UserEntity> = withMapper(userMapper) { userApi.getCurrentUser() }

    override fun getUser(id: String): Single<UserEntity> = withMapper(userMapper) { userApi.getUser(id) }

    override fun deleteUser(id: String) = userApi.deleteUser(id)

    override fun updateUser(newUser: UserEntity) = userApi.updateUser(newUser.id, userMapper.map(newUser))

    override fun updatePassword(id: String, passwords: PasswordsEntity) =
        userApi.updatePassword(id, passwordsMapper.map(passwords))
}