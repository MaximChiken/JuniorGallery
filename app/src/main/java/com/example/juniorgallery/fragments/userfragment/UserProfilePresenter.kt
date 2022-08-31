package com.example.juniorgallery.fragments.userfragment

import com.example.domain.gateways.PhotoGateway
import com.example.domain.gateways.UserGateway
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_paging.BasePagingPresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UserProfilePresenter @Inject constructor(
    private val userGateway: UserGateway,
    private val photoGateway: PhotoGateway,
) : BasePagingPresenter<UserProfileView>() {

    fun getCurrentUser() {
        userGateway.getCurrentUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.enableSetting(true)
                viewState.initUserInfo(it)
            }, {
                viewState.setError()
                viewState.enableSetting(false)
            })
    }

    override fun getPhoto(pageNumber: Int) = photoGateway.getPhoto(new = "true", page = pageNumber)
}