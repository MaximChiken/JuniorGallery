package com.example.juniorgallery.adapters.photo.photohome

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.domain.entities.PhotoInfoEntity
import com.example.juniorgallery.base.BasePhotoAdapter
import com.example.juniorgallery.databinding.PhotoItemBinding

class PhotoHomeAdapter(private val callback: (PhotoInfoEntity) -> Unit) : BasePhotoAdapter<PhotoHomeHolder>() {

    override fun createItemViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup) = PhotoHomeHolder(
        PhotoItemBinding.inflate(layoutInflater, parent, false),
        callback
    )
}