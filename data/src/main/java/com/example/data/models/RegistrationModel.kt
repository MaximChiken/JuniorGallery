package com.example.data.models

import com.example.data.base.BaseModel
import com.google.gson.annotations.SerializedName

class RegistrationModel(
    @SerializedName("id") val id: Int,
): BaseModel