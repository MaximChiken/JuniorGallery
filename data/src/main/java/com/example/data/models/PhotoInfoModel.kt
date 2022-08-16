package com.example.data.models

import com.example.data.base.BaseModel
import com.google.gson.annotations.SerializedName

data class PhotoInfoModel(
    @SerializedName("id") var id: Int?,
    @SerializedName("name") var name: String?,
    @SerializedName("dateCreate") var date: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("image") var image: ImageNameModel,
    @SerializedName("user") var user: String?
): BaseModel