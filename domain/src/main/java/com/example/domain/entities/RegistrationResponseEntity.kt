package com.example.domain.entities

import com.example.domain.base.BaseEntity

data class RegistrationResponseEntity(
    val id: Int,
    val email: String,
    val birthday: String,
    val username: String,
    ): BaseEntity