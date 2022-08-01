package com.example.juniorgallery.fragments.registrationfragmnet

import com.example.data.managers.TokenManager
import com.example.domain.entities.RegistrationRequestEntity
import com.example.domain.gateways.UserGateway
import com.example.juniorgallery.base.base_mvp.BasePresenter
import com.example.juniorgallery.validation.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class RegistrationPresenter @Inject constructor(
    private var usergateway: UserGateway,
    private var tokenManager: TokenManager,
) : BasePresenter<RegistrationView>() {

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
    ) = with(usergateway) {

        if (validationCheck(username, email, password, confirmPassword)) {
            postUser(RegistrationRequestEntity(email, date, username, password))
                .flatMap { loginUser(username, password) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.setLoader(true) }
                .doFinally { viewState.setLoader(false) }
                .subscribe({
                    tokenManager.login(it)
                    viewState.setToken(tokenManager.accessToken)
                    viewState.successRegistration()
                }, {
                    viewState.setError()
                })
        }
    }
}