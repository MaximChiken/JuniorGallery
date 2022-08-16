package com.example.juniorgallery.adapters.photo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.entities.PhotoInfoEntity
import com.example.juniorgallery.R

class PhotoAdapter(private val callback: (PhotoInfoEntity) -> Unit) :
    ListAdapter<PhotoInfoEntity, PhotoHolder>(PhotoDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        return PhotoHolder(view, callback)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount() = currentList.size
}