package com.example.juniorgallery.loginfragment

import com.example.domain.UserGateway
import com.example.juniorgallery.base.base_mvp.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class LoginPresenter @Inject constructor(var usergateway: UserGateway) : BasePresenter<LoginView>() {

    fun proceedLogin(username: String, password: String){
        usergateway.loginUser(username, password).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.toastsucc() //метод логина
            }, {
                viewState.toasterr()
            })
    }
}