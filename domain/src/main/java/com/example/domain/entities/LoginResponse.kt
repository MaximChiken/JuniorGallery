package com.example.domain.entities

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token") var token: String,
    @SerializedName("refresh_token") val refreshToken: String
)