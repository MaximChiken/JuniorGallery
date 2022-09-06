package com.example.data.managers.filemanager

import android.content.Context
import android.net.Uri
import android.os.Environment
import io.reactivex.rxjava3.core.Single
import java.io.File
import javax.inject.Inject

class FileManagerImpl @Inject constructor(private val context: Context) : FileManager {

    override fun getAttachment(uri: Uri?): Single<File> = Single.create {
        runCatching {
            val inputStream = context.contentResolver.openInputStream(uri!!)
            createTempFile().also {
                it.outputStream().apply {
                    write(inputStream?.readBytes())
                    inputStream?.close()
                    this.close()
                }
            }
        }.fold({ file ->
            it.onSuccess(file)
        }, { throwable ->
            it.onError(throwable)
        })
    }

    override fun createTempFile(): File {
        val filesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("tmp_image_file", ".jpg", filesDir)
    }
}