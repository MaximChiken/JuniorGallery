package com.example.domain.entities

import com.example.domain.base.BaseEntity

data class UserEntity(
    val id: String,
    val email: String,
    val birthday: String?,
    val username: String,
) : BaseEntity