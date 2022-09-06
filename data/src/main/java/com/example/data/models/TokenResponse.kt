package com.example.data.models

import com.example.data.base.BaseModel
import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("access_token") var token: String,
    @SerializedName("refresh_token") val refreshToken: String,
) : BaseModel