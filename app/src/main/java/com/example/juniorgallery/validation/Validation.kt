package com.example.juniorgallery.validation


interface Validation {

    fun emailValidate(email: String, callback: (Int?) -> Unit): Boolean

    fun usernameValidate(username: String, callback: (Int?) -> Unit): Boolean

    fun passwordValidate(password: String, confirmPassword: String, callback: (Int?) -> Unit): Boolean

    fun settingsPasswordValidation(
        newPassword: String,
        oldPassword: String,
        confirmNewPassword: String,
        callback: (Int?) -> Unit,
    ): Boolean
}