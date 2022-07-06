package com.example.juniorgallery.validation


import com.example.juniorgallery.R

class ConfirmPasswordValidation(
    private val confirmPassword: String,
    private val password: String,
    private val callback: (Int?) -> Unit,
) : Validation {

    override fun validate(): Int? {
        if (confirmPassword.isNotEmpty() && confirmPassword == password) {
            callback(null)
            return null
        }
        callback(R.string.no_confirm_password)
        return R.string.no_confirm_password
    }
}