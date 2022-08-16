package com.example.domain.entities

import com.example.domain.base.BaseEntity

data class PhotoInfoEntity(
    var id: Int,
    var name: String,
    var date: String,
    var description: String,
    var image: ImageNameEntity,
    var user: String
) : BaseEntity
