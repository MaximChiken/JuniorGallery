package com.example.juniorgallery.fragments.addphotofragment

import com.example.domain.entities.NewPhotoEntity
import com.example.domain.entities.PhotoInfoEntity
import com.example.domain.gateways.MediaObjectGateway
import com.example.domain.gateways.PhotoGateway
import com.example.juniorgallery.R
import com.example.juniorgallery.base.BaseUiMapper
import com.example.juniorgallery.base.base_mvp.BasePresenter
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import javax.inject.Inject

@InjectViewState
class AddPhotoPresenter @Inject constructor(
    private val mediaObjectGateway: MediaObjectGateway,
    private val photoGateway: PhotoGateway,
    private var uiPhotoInfoMapper: BaseUiMapper<PhotoInfoScreenModel, PhotoInfoEntity>,
) : BasePresenter<AddPhotoView>() {

    private lateinit var currentImage: File

    fun onImageTaken(photoFile: File) {
        currentImage = photoFile
    }

    fun sendImage(name: String, description: String, isNew: Boolean, isPopular: Boolean) {
        val body = currentImage.asRequestBody("multipart/form-data".toMediaTypeOrNull())
        val part = MultipartBody.Part.createFormData("file", currentImage.name, body)
        mediaObjectGateway.postMediaObject(part, currentImage.name)
            .flatMap { photoGateway.postPhoto(NewPhotoEntity(name, description, isNew, isPopular, it.id)) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.setProgressDialog() }
            .doFinally { viewState.dismissProgressDialog() }
            .subscribe({
                viewState.navigateToNewPhoto(uiPhotoInfoMapper.map(it))
            }, {
                viewState.showToast(R.string.connection_error)
            })
    }
}