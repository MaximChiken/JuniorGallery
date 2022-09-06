package com.example.juniorgallery.adapters.photo.photouser

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.juniorgallery.base.base_rcview.BasePhotoAdapter
import com.example.juniorgallery.databinding.ItemUserPhotoBinding
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel

class PhotoUserAdapter(private val callback: (PhotoInfoScreenModel) -> Unit) : BasePhotoAdapter<PhotoUserHolder>() {

    override fun createItemViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup) = PhotoUserHolder(
        ItemUserPhotoBinding.inflate(layoutInflater, parent, false),
        callback
    )
}