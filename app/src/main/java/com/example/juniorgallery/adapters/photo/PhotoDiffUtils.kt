package com.example.juniorgallery.adapters.photo

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entities.PhotoInfoEntity
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel

class PhotoDiffUtils : DiffUtil.ItemCallback<PhotoInfoScreenModel>() {

    override fun areItemsTheSame(oldItem: PhotoInfoScreenModel, newItem: PhotoInfoScreenModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PhotoInfoScreenModel, newItem: PhotoInfoScreenModel): Boolean =
        oldItem == newItem
}