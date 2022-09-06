package com.example.domain.entities

import com.example.domain.base.BaseEntity

data class NewPhotoEntity(
    var name: String,
    var description: String,
    var new: Boolean,
    var popular: Boolean,
    var image: Int,
) : BaseEntity
