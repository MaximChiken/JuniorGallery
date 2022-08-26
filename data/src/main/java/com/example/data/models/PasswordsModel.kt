package com.example.data.models


import com.example.data.base.BaseModel
import com.google.gson.annotations.SerializedName

data class PasswordsModel(
    @SerializedName("newPassword") var newPassword: String,
    @SerializedName("oldPassword") var oldPassword: String
):BaseModel