package com.example.domain.entities

import com.google.gson.annotations.SerializedName

data class RegistrationRequest(
    @SerializedName("email") val email: String,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("username") val userName: String,
    @SerializedName("password") val password: String,
)
