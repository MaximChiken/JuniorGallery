package com.example.juniorgallery.fragments.registrationfragmnet

import com.example.data.managers.TokenManager
import com.example.domain.entities.RegistrationRequestEntity
import com.example.domain.gateways.UserGateway
import com.example.juniorgallery.base.base_mvp.BasePresenter
import com.example.juniorgallery.validation.Validation
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class RegistrationPresenter @Inject constructor(
    private var userGateway: UserGateway,
    private var tokenManager: TokenManager,
    private var validation: Validation,
) : BasePresenter<RegistrationView>() {

    fun proceedRegistration(username: String, date: String, email: String, password: String, confirmPassword: String) =
        with(userGateway) {
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

    private fun validationCheck(username: String, email: String, password: String, confirmPassword: String): Boolean {
        with(validation) {
            val validationList: List<Int?> = listOf(
                usernameValidate(username, viewState::checkUserName),
                emailValidate(email, viewState::checkEmail),
                passwordValidate(password, confirmPassword, viewState::checkPassword)
            )
            var isValid = true
            validationList.forEach {
                if (it != null) isValid = false
            }
            return isValid
        }
    }
}