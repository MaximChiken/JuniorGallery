package com.example.juniorgallery.adapters.photo.photouser

import com.example.domain.entities.PhotoInfoEntity
import com.example.juniorgallery.base.BasePhotoViewHolder
import com.example.juniorgallery.databinding.UserPhotoItemBinding

class PhotoUserHolder(
    private val binding: UserPhotoItemBinding,
    callback: (PhotoInfoEntity) -> Unit,
) : BasePhotoViewHolder(binding, callback) {

    override fun initializeImageView() = binding.ivItem
}