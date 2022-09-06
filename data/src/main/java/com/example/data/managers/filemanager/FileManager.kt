package com.example.data.managers.filemanager

import android.net.Uri
import io.reactivex.rxjava3.core.Single
import java.io.File

interface FileManager {
    fun getAttachment(uri: Uri?): Single<File>
    fun createTempFile(): File
}