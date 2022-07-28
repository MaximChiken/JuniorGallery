package com.example.data.managers

import com.example.data.shared_preferences.TokenPreferences
import com.example.domain.entities.LoginEntity
import javax.inject.Inject


class TokenManagerImpl @Inject constructor(private val tokenPreferences: TokenPreferences) : TokenManager {


    override var tokens: LoginEntity
        get() = tokenPreferences.tokens
        set(value) {
            tokenPreferences.tokens = value
        }

    override val accessToken: String get() = tokens.accessToken
    override val refreshToken: String get() = tokens.refreshToken

    override fun login(response: LoginEntity) {
        tokens = response
    }

    override fun logout() {
        tokenPreferences.clearData()
    }
}