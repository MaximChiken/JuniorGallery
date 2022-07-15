package com.example.data.mappers

import com.example.data.models.LoginResponse
import com.example.domain.core.Mapper
import com.example.domain.entities.TokenEntity
import javax.inject.Inject

class TokenToLoginResponse @Inject constructor() : Mapper<LoginResponse, TokenEntity > {
    override fun map(model: LoginResponse): TokenEntity = with(model) {
        TokenEntity(token, refreshToken)
    }
}