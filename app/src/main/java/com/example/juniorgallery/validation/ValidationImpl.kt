package com.example.juniorgallery.validation

import android.util.Patterns
import com.example.juniorgallery.R
import javax.inject.Inject

class ValidationImpl @Inject constructor() : Validation {

    override fun usernameValidate(username: String, callback: (Int?) -> Unit): Int? {
        if (username.isNotEmpty() && username.matches("[A-Za-z1-9]+".toRegex())) {
            callback(null)
            return null
        }
        callback(R.string.no_user_name)
        return R.string.no_user_name
    }

    override fun emailValidate(email: String, callback: (Int?) -> Unit): Int? {
        if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            callback(null)
            return null
        }
        callback(R.string.no_email)
        return R.string.no_email
    }

    override fun passwordValidate(password: String, confirmPassword: String, callback: (Int?) -> Unit): Int? {
        if (password.isNotEmpty() &&
            password.matches("[A-Za-z1-9]+".toRegex()) &&
            password.length >= 5 &&
            confirmPassword == password
        ) {
            callback(null)
            return null
        }
        callback(R.string.no_password)
        return R.string.no_password
    }

//    override fun settingsUsernameValidation(newUsername: String, oldUsername: String, callback: (Int?) -> Unit): Unit? {
//        return when {
//            usernameValidate(newUsername, callback) != null -> callback(R.string.no_user_name)
//            oldUsername == newUsername -> callback(R.string.same_username)
//            else -> {
//                callback(null)
//                null
//            }
//        }
//    }
//
//    override fun settingsEmailValidation(newEmail: String, oldEmail: String, callback: (Int?) -> Unit): Unit? {
//        return when {
//            emailValidate(newEmail, callback) != null -> callback(R.string.no_email)
//            oldEmail == newEmail -> callback(R.string.same_email)
//            else -> {
//                callback(null)
//                null
//            }
//        }
//    }

    override fun settingsPasswordValidation(
        newPassword: String,
        oldPassword: String,
        confirmNewPassword: String,
        callback: (Int?) -> Unit,
    ): Boolean {
        return when {
            oldPassword == newPassword -> {
                callback(R.string.same_password)
                false
            }
            passwordValidate(newPassword, confirmNewPassword, callback) != null -> {
                callback(R.string.no_password)
                false
            }
            else -> {
                callback(null)
                true
            }
        }
    }
}