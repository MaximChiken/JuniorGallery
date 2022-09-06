package com.example.juniorgallery.screenviewmodels

import android.os.Parcelable
import com.example.juniorgallery.base.BaseScreenModel
import kotlinx.parcelize.Parcelize
import java.io.File

@Parcelize
data class TakenPhotoScreenModel(
    var takenPhoto: File,
) : Parcelable, BaseScreenModel