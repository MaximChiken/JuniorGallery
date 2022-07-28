package com.example.data.shared_preferences

import com.example.data.base.preferences.BasePreferences
import com.example.domain.entities.LoginEntity

interface TokenPreferences: BasePreferences {
    var tokens: LoginEntity
}