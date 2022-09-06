package com.example.juniorgallery.fragments.newphotofragment

import com.example.domain.entities.PhotoListEntity
import com.example.domain.gateways.PhotoGateway
import com.example.juniorgallery.base.BaseUiMapper
import com.example.juniorgallery.base.base_paging.BasePagingPresenter
import com.example.juniorgallery.screenviewmodels.PhotoListScreenModel
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class NewPhotoPresenter @Inject constructor(
    var photoGateway: PhotoGateway,
    private var uiPhotoMapper: BaseUiMapper<PhotoListScreenModel, PhotoListEntity>,
) : BasePagingPresenter<NewPhotoView>() {

    override fun initializeMapper() = uiPhotoMapper

    override fun getPhoto(pageNumber: Int) =
        photoGateway.getPhoto(new = "true", page = pageNumber)
}