package com.example.domain.entities

import com.example.domain.base.BaseEntity

data class UserInfoEntity(
    val userName: String,
    val password: String
): BaseEntity