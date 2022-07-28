package com.example.domain.entities

import com.example.domain.base.BaseEntity

data class RegistrationRequestEntity(
    val email: String,
    val birthday: String,
    val userName: String,
    val password: String,
): BaseEntity