package com.example.juniorgallery.fragments.choosemethoddialog

import android.net.Uri
import androidx.core.net.toUri
import com.example.data.managers.filemanager.FileManager
import com.example.juniorgallery.base.base_mvp_bottomsheet.MvpBottomSheetPresenter
import com.example.juniorgallery.screenviewmodels.TakenPhotoScreenModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import java.io.File
import javax.inject.Inject

@InjectViewState
class ChooseMethodPresenter @Inject constructor(
    private val fileManager: FileManager,
) : MvpBottomSheetPresenter<ChooseMethodView>() {

    private lateinit var currentImage: File

    fun onImageSelected(uri: Uri?) = getFile(uri).apply {
        subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { file ->
                currentImage = file
                viewState.updateImage(file.toUri(), TakenPhotoScreenModel(file))
            }
    }

    fun onCaptureTaken() {
        currentImage = getTempImage()
        viewState.captureImage(currentImage)
    }

    fun onImageCaptured(isCaptured: Boolean) {
        if (isCaptured) {
            viewState.updateImage(currentImage.toUri(), TakenPhotoScreenModel(currentImage))
        }
    }

    private fun getFile(uri: Uri?) = fileManager.getAttachment(uri)
    private fun getTempImage(): File = fileManager.createTempFile()
}