package com.example.juniorgallery.validation

class ConfirmPasswordValidation {

    fun confirmPasswordValidationCheck(password: String, confirmPassword: String): Boolean {
        return confirmPassword.isNotEmpty() && confirmPassword == password
    }
}