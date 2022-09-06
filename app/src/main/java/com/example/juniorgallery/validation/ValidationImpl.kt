package com.example.juniorgallery.validation

import android.util.Patterns
import com.example.juniorgallery.R
import javax.inject.Inject

class ValidationImpl @Inject constructor() : Validation {

    override fun usernameValidate(username: String, callback: (Int?) -> Unit): Boolean {
        if (username.isNotEmpty() && username.matches("[A-Za-z1-9]+".toRegex())) {
            callback(null)
            return true
        }
        callback(R.string.no_user_name)
        return false
    }

    override fun emailValidate(email: String, callback: (Int?) -> Unit): Boolean {
        if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            callback(null)
            return true
        }
        callback(R.string.no_email)
        return false
    }

    override fun passwordValidate(password: String, confirmPassword: String, callback: (Int?) -> Unit): Boolean {
        if (password.isNotEmpty() &&
            password.matches("[A-Za-z1-9]+".toRegex()) &&
            password.length >= 5 &&
            confirmPassword == password
        ) {
            callback(null)
            return true
        }
        callback(R.string.no_password)
        return false
    }

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
            passwordValidate(newPassword, confirmNewPassword, callback) -> true
            else -> false
        }
    }
}