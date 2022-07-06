package com.example.juniorgallery.validation

import com.example.juniorgallery.R

class PasswordValidation(private val password: String, private val callback: (Int?) -> Unit): Validation{

    override fun validate(): Int? {
        if (password.isNotEmpty() && password.matches("[A-Za-z1-9]+".toRegex()) && password.length >= 5) {
            callback(null)
            return null
        }
        callback(R.string.no_password)
        return R.string.no_password
    }
}