package com.example.data.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("access_token") var token: String,
    @SerializedName("refresh_token") val refreshToken: String,
)