package com.example.data.shared_preferences

import com.example.domain.entities.LoginEntity

interface TokenPreferences {
    var tokens: LoginEntity
}