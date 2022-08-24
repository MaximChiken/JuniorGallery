package com.example.juniorgallery.fragments.homefragments

import com.example.domain.entities.PhotoInfoEntity
import com.example.domain.gateways.PhotoGateway
import com.example.juniorgallery.base.base_mvp.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class HomePresenter @Inject constructor(
    private var photoGateway: PhotoGateway,
) : BasePresenter<HomeView>() {

    private val foundPhotoList: MutableList<PhotoInfoEntity> = mutableListOf()

    fun searchPhoto(photoName: String, isNew: String = "", isPopular: String = "") {
        foundPhotoList.clear()
        photoGateway.searchPhoto(photoName, isNew, isPopular)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { entity ->
                entity.data.forEach { foundPhotoList.add(it) }
                viewState.updateFragment(foundPhotoList)
            }
    }
}