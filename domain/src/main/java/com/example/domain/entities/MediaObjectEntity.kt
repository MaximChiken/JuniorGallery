package com.example.domain.entities

import com.example.domain.base.BaseEntity
import okhttp3.MultipartBody

data class MediaObjectEntity(
    val file: MultipartBody.Part,
    val name: String,
):BaseEntity