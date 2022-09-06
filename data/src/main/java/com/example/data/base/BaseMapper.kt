package com.example.data.base

import com.example.domain.base.BaseEntity

interface BaseMapper<M : BaseModel, E : BaseEntity> {
    fun map(entity: E): M
    fun map(model: M): E
}