package com.example.data.managers

import com.example.domain.entities.LoginEntity

interface TokenManager {
    val tokens: LoginEntity
    val accessToken: String
    val refreshToken: String

    fun login(response: LoginEntity)
    fun logout()
}