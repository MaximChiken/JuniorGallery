package com.example.juniorgallery.fragments.usersettings

import com.example.data.managers.TokenManager
import com.example.domain.entities.PasswordsEntity
import com.example.domain.entities.RegistrationResponseEntity
import com.example.domain.gateways.UserGateway
import com.example.juniorgallery.base.base_mvp.BasePresenter
import com.example.juniorgallery.validation.Validation
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import retrofit2.HttpException
import javax.inject.Inject

@InjectViewState
class UserSettingsPresenter @Inject constructor(
    private val userGateway: UserGateway,
    private val tokenManager: TokenManager,
    private val validation: Validation,
) : BasePresenter<UserSettingsView>() {

    fun deleteAccount(id: String) {
        userGateway.deleteUser(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                clearData()
            }, {
                viewState.toastSuccess()
            })
    }

    fun updateUserInfo(newUserInfo: RegistrationResponseEntity) {
        if (validationCheck(newUserInfo.username, newUserInfo.email)) {
            userGateway.updateUser(newUserInfo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.navigateToUserProfile()
                }, {
                    viewState.toastSuccess()
                })
        }
    }

    fun updatePassword(id: String, oldPassword: String, newPassword: String, confirmPassword: String) {
        if (checkPasswordValidation(oldPassword, newPassword, confirmPassword)) {
            userGateway.updatePassword(id, PasswordsEntity(newPassword, oldPassword))
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, {
                    if (it is HttpException) {
                        if (it.code() == 500) {
                            viewState.toastSuccess()
                        }
                    }
                })
        }
    }

    fun clearData() {
        tokenManager.logout()
        viewState.navigateBack()
    }

    private fun checkPasswordValidation(oldPassword: String, newPassword: String, confirmPassword: String) =
        (validation.settingsPasswordValidation(newPassword, oldPassword, confirmPassword, viewState::checkPassword))

    private fun validationCheck(username: String, email: String): Boolean {
        with(validation) {
            val validationList: List<Int?> = listOf(
                usernameValidate(username, viewState::checkUserName),
                emailValidate(email, viewState::checkEmail),
            )
            var isValid = true
            validationList.forEach {
                if (it != null) isValid = false
            }
            return isValid
        }
    }
}