package com.example.juniorgallery.fragments.addphotofragment

import android.graphics.Bitmap
import com.example.domain.entities.MediaObjectEntity
import com.example.domain.gateways.MediaObjectGateway
import com.example.juniorgallery.base.base_mvp.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream
import javax.inject.Inject

@InjectViewState
class AddPhotoPresenter @Inject constructor(
    private val mediaObjectGateway: MediaObjectGateway
): BasePresenter<AddPhotoView>() {

    fun sendImage(image:Bitmap){
        val stream = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG, 80, stream)
        val byteArray = stream.toByteArray()
        val body = MultipartBody.Part.createFormData(
            "Amogu1231231312312312312s", "newPhoto231312312312312312312",
            byteArray.toRequestBody("image/*".toMediaTypeOrNull(), 0, byteArray.size)
        )
        mediaObjectGateway.postMediaObject(body, "ABOBUS1231231231231231")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({},{})
    }

}