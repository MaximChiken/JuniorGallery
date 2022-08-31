package com.example.data.models

import com.example.data.base.BaseModel
import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody

data class MediaObjectModel(
    @SerializedName("file") val file: MultipartBody.Part,
    @SerializedName("name") val name: String,
):BaseModel