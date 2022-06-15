package com.example.juniorgallery.validation

class PasswordValidation {

    fun passwordValidationCheck(password: String): Boolean {
        return password.isNotEmpty() && password.matches("[A-Za-z1-9]+".toRegex())
    }
}