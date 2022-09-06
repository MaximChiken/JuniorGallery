package com.example.data.gateway_impl

import com.example.data.api.UserApi
import com.example.data.base.BaseGateway
import com.example.data.base.BaseMapper
import com.example.data.models.PasswordsModel
import com.example.data.models.UserModel
import com.example.domain.entities.PasswordsEntity
import com.example.domain.entities.UserEntity
import com.example.domain.gateways.UserGateway
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserGatewayImpl @Inject constructor(
    private val userApi: UserApi,
    private val userMapper: BaseMapper<UserModel, UserEntity>,
    private val passwordsMapper: BaseMapper<PasswordsModel, PasswordsEntity>,
) : UserGateway, BaseGateway {

    override fun getCurrentUser(): Single<UserEntity> = withMapper(userMapper) { userApi.getCurrentUser() }

    override fun getUser(id: String): Single<UserEntity> = withMapper(userMapper) { userApi.getUser(id) }

    override fun deleteUser(id: String) = userApi.deleteUser(id)

    override fun updateUser(newUser: UserEntity) = userApi.updateUser(newUser.id, userMapper.map(newUser))

    override fun updatePassword(id: String, passwords: PasswordsEntity) =
        userApi.updatePassword(id, passwordsMapper.map(passwords))
}