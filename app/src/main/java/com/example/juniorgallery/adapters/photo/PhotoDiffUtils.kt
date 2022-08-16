package com.example.juniorgallery.adapters.photo

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entities.PhotoInfoEntity

class PhotoDiffUtils : DiffUtil.ItemCallback<PhotoInfoEntity>() {

    override fun areItemsTheSame(oldItem: PhotoInfoEntity, newItem: PhotoInfoEntity): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PhotoInfoEntity, newItem: PhotoInfoEntity): Boolean =
        oldItem == newItem
}