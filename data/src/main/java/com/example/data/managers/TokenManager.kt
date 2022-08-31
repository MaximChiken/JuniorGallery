package com.example.data.managers

import com.example.domain.entities.TokenEntity

interface TokenManager {
    val tokens: TokenEntity
    val accessToken: String
    val refreshToken: String

    fun login(response: TokenEntity)
    fun logout()
}