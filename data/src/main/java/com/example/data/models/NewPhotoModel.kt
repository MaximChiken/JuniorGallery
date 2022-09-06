package com.example.data.models

import com.example.data.base.BaseModel
import com.google.gson.annotations.SerializedName

data class NewPhotoModel(
    @SerializedName("name") var name: String,
    @SerializedName("description") var description: String,
    @SerializedName("new") var new: Boolean,
    @SerializedName("popular") var popular: Boolean,
    @SerializedName("image") var image: String,
) : BaseModel