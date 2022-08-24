package com.example.juniorgallery.fragments.popularphotofragment

import com.example.domain.gateways.PhotoGateway
import com.example.juniorgallery.base.base_paging.BasePagingPresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class PopularPhotoPresenter @Inject constructor(
    var photoGateway: PhotoGateway,
) : BasePagingPresenter<PopularPhotoView>() {

    override fun getPhoto(pageNumber: Int) =
        photoGateway.getPhoto(popular = "true", page = pageNumber)
}