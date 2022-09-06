package com.example.juniorgallery.fragments.loginfragment

import com.example.data.managers.tokenmanager.TokenManager
import com.example.domain.gateways.AuthGateway
import com.example.juniorgallery.base.base_mvp.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class LoginPresenter @Inject constructor(
    private var authGateway: AuthGateway,
    private var tokenManager: TokenManager,
) : BasePresenter<LoginView>() {

    fun proceedLogin(username: String, password: String) {
        authGateway.loginUser(username, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.setProgressDialog() }
            .doFinally { viewState.dismissProgressDialog() }
            .subscribe({
                tokenManager.login(it)
                viewState.successLogin()
            }, {
                viewState.setError()
            })
    }
}

