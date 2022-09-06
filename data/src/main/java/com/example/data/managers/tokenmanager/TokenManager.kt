package com.example.data.managers.tokenmanager

import com.example.domain.entities.TokenEntity

interface TokenManager {
    val tokens: TokenEntity
    val accessToken: String
    val refreshToken: String

    fun login(response: TokenEntity)
    fun logout()
}