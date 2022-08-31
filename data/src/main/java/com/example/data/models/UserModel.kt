package com.example.data.models

import com.example.data.base.BaseModel
import com.google.gson.annotations.SerializedName

class UserModel(
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String?,
    @SerializedName("email")val email: String?,
    @SerializedName("birthday") val birthday: String?,
) : BaseModel