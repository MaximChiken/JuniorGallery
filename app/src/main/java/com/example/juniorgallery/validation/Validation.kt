package com.example.juniorgallery.validation


interface Validation {

    fun emailValidate(email: String, callback: (Int?) -> Unit): Int?

    fun usernameValidate(username: String, callback: (Int?) -> Unit): Int?

    fun passwordValidate(password: String, confirmPassword: String, callback: (Int?) -> Unit): Int?

//    fun settingsUsernameValidation(newUsername: String, oldUsername: String, callback: (Int?) -> Unit): Unit?
//
//    fun settingsEmailValidation(newEmail: String, oldEmail: String, callback: (Int?) -> Unit): Unit?

    fun settingsPasswordValidation(
        newPassword: String,
        oldPassword: String,
        confirmNewPassword: String,
        callback: (Int?) -> Unit,
    ): Boolean
}