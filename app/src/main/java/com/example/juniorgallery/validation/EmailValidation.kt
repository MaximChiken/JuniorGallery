package com.example.juniorgallery.validation

import android.util.Patterns

class EmailValidation {

    fun emailValidationCheck(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}