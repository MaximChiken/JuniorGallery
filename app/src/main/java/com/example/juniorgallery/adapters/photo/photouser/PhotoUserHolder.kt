package com.example.juniorgallery.adapters.photo.photouser

import com.example.juniorgallery.base.base_rcview.BasePhotoViewHolder
import com.example.juniorgallery.databinding.ItemUserPhotoBinding
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel

class PhotoUserHolder(
    private val binding: ItemUserPhotoBinding,
    callback: (PhotoInfoScreenModel) -> Unit,
) : BasePhotoViewHolder(binding, callback) {

    override fun initializeImageView() = binding.ivItem
}