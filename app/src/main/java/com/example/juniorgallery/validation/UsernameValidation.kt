package com.example.juniorgallery.validation

import com.example.juniorgallery.R

class UsernameValidation(private val username: String, private val callback: (Int?) -> Unit) : Validation {

    override fun validate(): Int? {
        if (username.isNotEmpty() && username.matches("[A-Za-z1-9]+".toRegex())) {
            callback(null)
            return null
        }
        callback(R.string.no_user_name)
        return R.string.no_user_name
    }
}