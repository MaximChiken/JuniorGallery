package com.example.data.models

import com.example.data.base.BaseModel
import com.google.gson.annotations.SerializedName

data class RegistrationModel(
    @SerializedName("email") val email: String,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("username") val userName: String,
    @SerializedName("password") val password: String,
): BaseModel
