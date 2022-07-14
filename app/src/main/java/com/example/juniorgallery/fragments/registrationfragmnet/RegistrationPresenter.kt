package com.example.juniorgallery.fragments.registrationfragmnet

import com.example.domain.UserGateway
import com.example.domain.core.Mapper
import com.example.domain.entities.UserFullInfoEntity
import com.example.juniorgallery.base.base_mvp.BasePresenter
import com.example.juniorgallery.fragments.registrationfragmnet.models.UiRegistration
import com.example.juniorgallery.validation.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class RegistrationPresenter @Inject constructor(
    private var usergateway: UserGateway<UiRegistration>,
    private val userDomainToRegistrationRequest: Mapper<UiRegistration, UserFullInfoEntity>,
) :
    BasePresenter<RegistrationView>() {


    private fun validationCheck(username: String, email: String, password: String, confirmPassword: String): Boolean {

        val validationList: List<Validation> = listOf(
            UsernameValidation(username, viewState::checkUserName),
            EmailValidation(email, viewState::checkEmail),
            PasswordValidation(password, viewState::checkPassword),
            ConfirmPasswordValidation(password, confirmPassword, viewState::checkConfirmPassword))

        var isValid = true

        validationList.forEach {
            it.validate()?.run { isValid = false }
        }
        return isValid

    }

    fun proceedRegistration(
        username: String,
        date: String,
        email: String,
        password: String,
        confirmPassword: String,
    ) {

        if (validationCheck(username, email, password, confirmPassword)) {
            usergateway.postUser(userDomainToRegistrationRequest.map(UiRegistration(email, date, username, password)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.toastsucc() //метод логина
                }, {
                    viewState.toasterr()
                })
        }
    }
}