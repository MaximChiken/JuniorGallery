package com.example.juniorgallery.registrationfragmnet

import android.widget.Toast
import com.example.juniorgallery.base.base_mvp.BasePresenter
import com.example.juniorgallery.validation.ConfirmPasswordValidation
import com.example.juniorgallery.validation.EmailValidation
import com.example.juniorgallery.validation.PasswordValidation
import com.example.juniorgallery.validation.UsernameValidation
import moxy.InjectViewState
import java.util.*
import javax.inject.Inject


@InjectViewState
class RegistrationPresenter @Inject constructor() : BasePresenter<RegistrationView>() {

    private var current = ""
    private val dateMask = "ddmmyyyy"
    private val calendar: Calendar = Calendar.getInstance()


    fun setBirthDateMask(s: CharSequence) {
        if (s.toString() != current) {
            var date = s.toString().replace("[^\\d.]".toRegex(), "")
            val cleanCalendar = current.replace("[^\\d.]".toRegex(), "")
            val cl = date.length
            var sel = cl
            var i = 2
            while (i <= cl && i < 6) {
                sel++
                i += 2
            }
            //Fix for pressing delete next to a forward slash
            if (date == cleanCalendar) sel--
            if (date.length < 8) {
                date += dateMask.substring(date.length)
            } else {
                //This part makes sure that when we finish entering numbers
                //the date is correct, fixing it otherwise
                var day = date.substring(0, 2).toInt()
                var month = date.substring(2, 4).toInt()
                var year = date.substring(4, 8).toInt()
                if (month > 12) month = 12
                calendar[Calendar.MONTH] = month - 1
                year = if (year < 1900) 1900
                else if (year > 2022) 2022
                else year
                calendar[Calendar.YEAR] = year
                // ^ first set year for the line below to work correctly
                //with leap years - otherwise, date e.g. 29/02/2012
                //would be automatically corrected to 28/02/2012
                day =
                    if (day > calendar.getActualMaximum(Calendar.DATE)) calendar
                        .getActualMaximum(Calendar.DATE)
                    else day
                date = String.format("%02d%02d%02d", day, month, year)
            }
            date = String.format("%s/%s/%s", date.substring(0, 2),
                date.substring(2, 4),
                date.substring(4, 8))
            sel = if (sel < 0) 0 else sel
            current = date
            viewState.setBirthdate(date, sel)
        }
    }

    private fun validationCheck(username: String, email: String, password: String, confirmPassword: String): Boolean {
        val isUsernameValid = UsernameValidation().usernameValidationCheck(username)
        val isEmailValid = EmailValidation().emailValidationCheck(email)
        val isPasswordValid = PasswordValidation().passwordValidationCheck(password)
        val isConfirmValid = ConfirmPasswordValidation().confirmPasswordValidationCheck(password,
            confirmPassword)

        viewState.checkUserName(isUsernameValid)
        viewState.checkEmail(isEmailValid)
        viewState.checkPassword(isPasswordValid)
        viewState.checkConfirmPassword(isConfirmValid)

        if (isUsernameValid && isEmailValid && isPasswordValid && isConfirmValid) {
            return true
        }
        return false
    }

    fun proceedRegistration(username: String,date:String, email: String, password: String, confirmPassword: String){
        if(validationCheck(username, email, password, confirmPassword)){
            viewState.toast()
        }
    }
}