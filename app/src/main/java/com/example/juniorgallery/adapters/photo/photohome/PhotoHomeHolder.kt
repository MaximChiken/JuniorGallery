package com.example.juniorgallery.adapters.photo.photohome

import com.example.juniorgallery.base.base_rcview.BasePhotoViewHolder
import com.example.juniorgallery.databinding.ItemPhotoBinding
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel

class PhotoHomeHolder(
    private val binding: ItemPhotoBinding,
    callback: (PhotoInfoScreenModel) -> Unit,
) : BasePhotoViewHolder(binding, callback) {

    override fun initializeImageView() = binding.ivItem
}