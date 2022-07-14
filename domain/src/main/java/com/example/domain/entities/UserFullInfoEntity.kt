package com.example.domain.entities

import com.example.domain.core.Mapper

data class UserFullInfoEntity(
    val email: String,
    val birthday: String,
    val userName: String,
    val password: String,
)