package com.example.juniorgallery.fragments.newphotofragment

import com.example.domain.gateways.PhotoGateway
import com.example.juniorgallery.base.base_paging.BasePagingPresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class NewPhotoPresenter @Inject constructor(
    var photoGateway: PhotoGateway,
) : BasePagingPresenter<NewPhotoView>() {

    override fun getPhoto(pageNumber: Int) =
        photoGateway.getPhoto(new = true, popular = false, pageNumber)
}