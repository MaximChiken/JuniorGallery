package com.example.domain.entities

import com.example.domain.base.BaseEntity

data class LoginEntity (
    var accessToken: String,
    var refreshToken: String
): BaseEntity