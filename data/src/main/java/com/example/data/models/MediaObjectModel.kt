package com.example.data.models

import com.example.data.base.BaseModel
import com.google.gson.annotations.SerializedName

data class MediaObjectModel(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
) : BaseModel