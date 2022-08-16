package com.example.data.models

import com.example.data.base.BaseModel
import com.google.gson.annotations.SerializedName

data class ImageNameModel(
    @SerializedName("name") var name: String
): BaseModel