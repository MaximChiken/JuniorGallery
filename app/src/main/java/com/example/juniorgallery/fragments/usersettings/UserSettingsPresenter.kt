package com.example.juniorgallery.fragments.usersettings

import com.example.data.managers.TokenManager
import com.example.juniorgallery.base.base_mvp.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class UserSettingsPresenter @Inject constructor(
    private val tokenManager: TokenManager,
) : BasePresenter<UserSettingsView>() {

    fun clearData() {
        tokenManager.logout()
    }
}