package com.example.domain.entities

data class TokenEntity (
    var token: String,
    val refreshToken: String
)