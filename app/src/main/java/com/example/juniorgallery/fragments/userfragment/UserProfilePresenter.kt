package com.example.juniorgallery.fragments.userfragment

import com.example.domain.entities.PhotoListEntity
import com.example.domain.gateways.PhotoGateway
import com.example.domain.gateways.UserGateway
import com.example.juniorgallery.base.BaseUiMapper
import com.example.juniorgallery.base.base_paging.BasePagingPresenter
import com.example.juniorgallery.screenviewmodels.PhotoListScreenModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UserProfilePresenter @Inject constructor(
    private val userGateway: UserGateway,
    private val photoGateway: PhotoGateway,
    private var uiPhotoMapper: BaseUiMapper<PhotoListScreenModel, PhotoListEntity>,
) : BasePagingPresenter<UserProfileView>() {

    private lateinit var userId: String

    override fun initializeMapper() = uiPhotoMapper

    override fun getPhoto(pageNumber: Int) = photoGateway.getUserPhoto(pageNumber, userId)

    override fun onFirstViewAttach() {
        uiPhotoListMapper = initializeMapper()
        userGateway.getCurrentUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.setLoader(true) }
            .doOnSuccess { viewState.setLoader(false) }
            .subscribe({
                userId = it.id
                getPage()
                viewState.enableSetting(true)
                viewState.initUserInfo(it)
            }, {
                viewState.setError()
                viewState.enableSetting(false)
            })
    }
}