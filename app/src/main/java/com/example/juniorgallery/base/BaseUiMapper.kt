package com.example.juniorgallery.base

import com.example.domain.base.BaseEntity

interface BaseUiMapper<SM: BaseScreenModel, E:BaseEntity> {
    fun map(entity: E): SM
    fun map(model: SM): E
}