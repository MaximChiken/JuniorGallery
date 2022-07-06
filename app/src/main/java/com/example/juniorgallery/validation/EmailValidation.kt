package com.example.juniorgallery.validation

import android.util.Patterns
import com.example.juniorgallery.R

class EmailValidation(private val email: String, private val callback: (Int?) -> Unit): Validation {

    override fun validate(): Int? {
        if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            callback(null)
            return null
        }
        callback(R.string.no_email)
        return R.string.no_email
    }
}