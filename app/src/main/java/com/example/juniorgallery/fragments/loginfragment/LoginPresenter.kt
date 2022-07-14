package com.example.juniorgallery.fragments.loginfragment

import com.example.domain.UserGateway
import com.example.juniorgallery.base.base_mvp.BasePresenter
import com.example.juniorgallery.fragments.loginfragment.models.UiLogin
import com.example.juniorgallery.fragments.registrationfragmnet.models.UiRegistration
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class LoginPresenter @Inject constructor(private var usergateway: UserGateway<UiLogin>) :
    BasePresenter<LoginView>() {

    fun proceedLogin(username: String, password: String) {
        usergateway.loginUser(username, password)
    }
}