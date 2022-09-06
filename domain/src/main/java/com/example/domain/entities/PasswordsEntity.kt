package com.example.domain.entities

import com.example.domain.base.BaseEntity

data class PasswordsEntity(
    var newPassword: String,
    var oldPassword: String,
) : BaseEntity