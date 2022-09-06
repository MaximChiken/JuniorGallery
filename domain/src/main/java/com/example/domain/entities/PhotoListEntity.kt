package com.example.domain.entities

import com.example.domain.base.BaseEntity

data class PhotoListEntity(
    var data: List<PhotoInfoEntity>,
) : BaseEntity
