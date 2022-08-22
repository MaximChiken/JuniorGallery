package com.example.juniorgallery.fragments.detailviewfragment

import androidx.constraintlayout.motion.utils.ViewState
import com.example.domain.gateways.UserGateway
import com.example.juniorgallery.base.base_mvp.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class DetailViewPresenter @Inject constructor(private var userGateway: UserGateway) : BasePresenter<DetailViewView>() {

    fun getUser(id: String) =
        userGateway.getUser(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it ->
                viewState.setUserName(it.username)
            }
}