package com.example.juniorgallery.fragments.welcomefragment

import com.example.data.managers.tokenmanager.TokenManager
import com.example.juniorgallery.base.base_mvp.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class WelcomePresenter @Inject constructor(private val tokenManager: TokenManager) : BasePresenter<WelcomeView>() {

    fun checkAuth() {
        if (tokenManager.accessToken.isNotEmpty()) {
            viewState.navigateToHome()
        }
    }
}