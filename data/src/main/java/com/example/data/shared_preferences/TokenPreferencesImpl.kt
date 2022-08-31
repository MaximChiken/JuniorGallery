package com.example.data.shared_preferences

import android.content.SharedPreferences
import com.example.data.base.preferences.BasePreferencesImpl
import com.example.domain.entities.TokenEntity

class TokenPreferencesImpl(private val sharedPreferences: SharedPreferences) :
    BasePreferencesImpl(sharedPreferences), TokenPreferences {

    override var tokens: TokenEntity
        get() = TokenEntity(
            accessToken = this.getString(ACCESS_TOKEN) ?: "",
            refreshToken = this.getString(REFRESH_TOKEN) ?: ""
        )
        set(value) = sharedPreferences.edit().apply {
            putSting(ACCESS_TOKEN, value.accessToken)
            putSting(REFRESH_TOKEN, value.refreshToken)
        }.apply()

    companion object {
        const val ACCESS_TOKEN = "access_token"
        const val REFRESH_TOKEN = "refresh_token"
    }
}