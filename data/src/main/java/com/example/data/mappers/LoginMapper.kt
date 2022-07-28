package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.LoginResponse
import com.example.domain.entities.LoginEntity
import javax.inject.Inject

class LoginMapper @Inject constructor(): BaseMapper<LoginResponse, LoginEntity> {
    override fun map(entity: LoginEntity): LoginResponse {
        TODO("Not yet implemented")
    }

    override fun map(model: LoginResponse): LoginEntity = LoginEntity(
        accessToken = model.token,
        refreshToken = model.refreshToken
    )
}