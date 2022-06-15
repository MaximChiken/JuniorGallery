package com.example.juniorgallery.validation

class UsernameValidation() {

    fun usernameValidationCheck(username: String): Boolean {
        return username.isNotEmpty() && username.matches("[A-Za-z1-9]+".toRegex())
    }
}