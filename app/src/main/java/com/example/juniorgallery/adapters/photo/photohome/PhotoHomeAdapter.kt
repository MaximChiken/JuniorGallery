package com.example.juniorgallery.adapters.photo.photohome

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.domain.entities.PhotoInfoEntity
import com.example.juniorgallery.base.BasePhotoAdapter
import com.example.juniorgallery.databinding.PhotoItemBinding

class PhotoHomeAdapter(private val callback: (PhotoInfoEntity) -> Unit) : BasePhotoAdapter<PhotoHomeHolder>()
/*    ListAdapter<PhotoInfoEntity, PhotoHolder>(PhotoDiffUtils()) */{

    override fun createItemViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup) = PhotoHomeHolder(
        PhotoItemBinding.inflate(layoutInflater, parent, false),
        callback
    )

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
//        val view = LayoutInflater.from(parent.context).inflate(View, parent, false)
//        return PhotoHolder(view, callback)
//    }

//    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
//        holder.bind(currentList[position])
//    }

//    override fun getItemCount() = currentList.size
}