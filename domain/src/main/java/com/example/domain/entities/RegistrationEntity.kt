package com.example.domain.entities

import com.example.domain.base.BaseEntity

data class RegistrationEntity(
    val email: String,
    val birthday: String,
    val userName: String,
    val password: String,
) : BaseEntity