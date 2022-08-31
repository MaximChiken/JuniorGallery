package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.TokenResponse
import com.example.domain.entities.TokenEntity
import javax.inject.Inject

class TokenMapper @Inject constructor(): BaseMapper<TokenResponse, TokenEntity> {
    override fun map(entity: TokenEntity): TokenResponse {
        TODO("Not yet implemented")
    }

    override fun map(model: TokenResponse): TokenEntity = TokenEntity(
        accessToken = model.token,
        refreshToken = model.refreshToken
    )
}