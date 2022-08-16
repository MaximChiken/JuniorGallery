package com.example.domain.entities

import com.example.domain.base.BaseEntity

data class PhotoEntity(
    var data: List<PhotoInfoEntity>
): BaseEntity
