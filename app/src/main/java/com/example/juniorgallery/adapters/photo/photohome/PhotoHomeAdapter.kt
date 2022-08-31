package com.example.juniorgallery.adapters.photo.photohome

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.domain.entities.PhotoInfoEntity
import com.example.juniorgallery.base.base_rcview.BasePhotoAdapter
import com.example.juniorgallery.databinding.ItemPhotoBinding
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel

class PhotoHomeAdapter(private val callback: (PhotoInfoScreenModel) -> Unit) : BasePhotoAdapter<PhotoHomeHolder>() {

    override fun createItemViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup) = PhotoHomeHolder(
        ItemPhotoBinding.inflate(layoutInflater, parent, false),
        callback
    )
}