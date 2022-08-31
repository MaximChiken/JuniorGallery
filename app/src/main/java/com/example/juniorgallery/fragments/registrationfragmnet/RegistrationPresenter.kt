package com.example.juniorgallery.fragments.registrationfragmnet

import com.example.data.managers.TokenManager
import com.example.domain.entities.RegistrationEntity
import com.example.domain.gateways.UserGateway
import com.example.juniorgallery.R
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

    fun proceedRegistration(userInfo: RegistrationEntity, confirmPassword: String) = with(userInfo) {
        if (validationCheck(userName, email, password, confirmPassword)) {
            userGateway.postUser(userInfo)
                .flatMap { userGateway.loginUser(userName, password) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.setLoader(true) }
                .doFinally { viewState.setLoader(false) }
                .subscribe({
                    tokenManager.login(it)
                    viewState.successRegistration()
                }, {
                    viewState.showToast(R.string.connection_error)
                })
        }
    }

    private fun validationCheck(username: String, email: String, password: String, confirmPassword: String): Boolean {
        with(validation) {
            val validationList: List<Boolean> = listOf(
                usernameValidate(username, viewState::checkUserName),
                emailValidate(email, viewState::checkEmail),
                passwordValidate(password, confirmPassword, viewState::checkPassword)
            )
            var isValid = true
            validationList.forEach {
                if (it) isValid = false
            }
            return isValid
        }
    }
}