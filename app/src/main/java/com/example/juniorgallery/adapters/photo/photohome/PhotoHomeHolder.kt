package com.example.juniorgallery.adapters.photo.photohome

import com.example.domain.entities.PhotoInfoEntity
import com.example.juniorgallery.base.BasePhotoViewHolder
import com.example.juniorgallery.databinding.PhotoItemBinding

class PhotoHomeHolder(
    private val binding: PhotoItemBinding,
    callback: (PhotoInfoEntity) -> Unit,
) : BasePhotoViewHolder(binding, callback) {

    override fun initializeImageView() = binding.ivItem
}