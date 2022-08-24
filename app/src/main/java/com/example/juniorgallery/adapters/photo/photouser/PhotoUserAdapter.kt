package com.example.juniorgallery.adapters.photo.photouser

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.domain.entities.PhotoInfoEntity
import com.example.juniorgallery.base.BasePhotoAdapter
import com.example.juniorgallery.databinding.UserPhotoItemBinding

class PhotoUserAdapter(private val callback: (PhotoInfoEntity) -> Unit) : BasePhotoAdapter<PhotoUserHolder>() {

    override fun createItemViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup) = PhotoUserHolder(
        UserPhotoItemBinding.inflate(layoutInflater, parent, false),
        callback
    )
}