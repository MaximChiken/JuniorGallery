package com.example.data.mappers

import com.example.data.models.LoginResponse
import com.example.domain.core.Mapper
import com.example.domain.entities.TokenEntity
import javax.inject.Inject

class TokenToLoginResponse @Inject constructor() : Mapper<TokenEntity, LoginResponse> {
    override fun map(model: TokenEntity): LoginResponse = with(model) {
        LoginResponse(token, refreshToken)
    }
}