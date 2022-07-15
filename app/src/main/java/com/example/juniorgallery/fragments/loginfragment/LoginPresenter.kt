package com.example.juniorgallery.fragments.loginfragment

import android.util.Log
import com.example.domain.UserGateway
import com.example.domain.core.Mapper
import com.example.domain.entities.UserInfoEntity
import com.example.juniorgallery.base.base_mvp.BasePresenter
import com.example.juniorgallery.models.UiLogin
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class LoginPresenter @Inject constructor(
    private var usergateway: UserGateway,
    private val UiLoginToUserInfoDomain: Mapper<UiLogin, UserInfoEntity>,
) :
    BasePresenter<LoginView>() {

    fun proceedLogin(username: String, password: String) {
        usergateway.loginUser(UiLoginToUserInfoDomain.map(UiLogin(username, password)))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.w("TAG", it.token)
                viewState.toastsucc() //метод логина
            }, {
                viewState.toasterr()
            })
    }
}