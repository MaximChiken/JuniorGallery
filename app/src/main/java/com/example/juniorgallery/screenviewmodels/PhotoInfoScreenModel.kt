package com.example.juniorgallery.screenviewmodels

import android.os.Parcelable
import com.example.juniorgallery.base.BaseScreenModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoInfoScreenModel(
    var id: Int,
    var name: String,
    var date: String,
    var description: String,
    var image: String,
    var user: String,
) : Parcelable, BaseScreenModel