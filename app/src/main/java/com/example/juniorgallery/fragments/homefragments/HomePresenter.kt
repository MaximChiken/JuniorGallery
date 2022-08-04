package com.example.juniorgallery.fragments.homefragments

import com.example.data.managers.TokenManager
import com.example.domain.gateways.UserGateway
import com.example.juniorgallery.base.base_mvp.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val userGateway: UserGateway,
    private val tokenManager: TokenManager,
) : BasePresenter<HomeView>() {

    fun checkAuth() {
        if (tokenManager.accessToken == "") {
            viewState.navigateBack()
        }
    }

    fun clearData() {
        tokenManager.logout()
    }

    fun getCurrentUser() {
        userGateway.getUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.setId(it.id)
            }, {
                viewState.setError()
            })
    }
}