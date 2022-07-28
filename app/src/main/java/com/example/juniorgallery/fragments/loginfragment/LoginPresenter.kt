package com.example.juniorgallery.fragments.loginfragment

import android.content.SharedPreferences
import android.util.Log
import com.example.data.managers.TokenManager
import com.example.data.shared_preferences.TokenPreferencesImpl
import com.example.domain.entities.LoginEntity
import com.example.domain.gateways.UserGateway
import com.example.juniorgallery.base.base_mvp.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class LoginPresenter @Inject constructor(
    private var usergateway: UserGateway,
    private var tokenManager: TokenManager
) : BasePresenter<LoginView>() {



    fun proceedLogin(username: String, password: String) {
        usergateway.loginUser(username, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                tokenManager.login(it)
                val token = tokenManager.accessToken
                viewState.setToken(token)
            },{
                viewState.setError()
            })
    }
}

