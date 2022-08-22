package com.example.juniorgallery.fragments.userfragment

import com.example.data.managers.TokenManager
import com.example.domain.gateways.UserGateway
import com.example.juniorgallery.base.base_mvp.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UserProfilePresenter @Inject constructor(
    private val userGateway: UserGateway,
    private val tokenManager: TokenManager,
) : BasePresenter<UserProfileView>() {

    fun clearData() {
        tokenManager.logout()
    }

    fun getCurrentUser() {
        userGateway.getCurrentUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.setId(it.id)
            }, {
                viewState.setError()
            })
    }
}