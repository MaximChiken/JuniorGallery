package com.example.data.models

import com.example.data.base.BaseModel
import com.google.gson.annotations.SerializedName

data class PhotoModel(
    @SerializedName("data") var data: List<PhotoInfoModel>
):BaseModel
