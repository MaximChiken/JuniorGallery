package com.example.domain.entities

import com.example.domain.base.BaseEntity

data class TokenEntity(
    var accessToken: String,
    var refreshToken: String,
) : BaseEntity