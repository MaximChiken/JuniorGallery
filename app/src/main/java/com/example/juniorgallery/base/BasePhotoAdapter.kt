package com.example.juniorgallery.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.entities.PhotoInfoEntity
import com.example.juniorgallery.adapters.photo.PhotoDiffUtils

abstract class BasePhotoAdapter<VH : BasePhotoViewHolder> : ListAdapter<PhotoInfoEntity, VH>(PhotoDiffUtils()) {

    abstract fun createItemViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
//        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        createItemViewHolder(LayoutInflater.from(parent.context), parent)


    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount() = currentList.size
}