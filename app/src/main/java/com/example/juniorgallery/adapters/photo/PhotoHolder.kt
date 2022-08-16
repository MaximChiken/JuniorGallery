package com.example.juniorgallery.adapters.photo

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entities.PhotoInfoEntity
import com.example.juniorgallery.databinding.PhotoItemBinding

class PhotoHolder(view: View, private val callback: (PhotoInfoEntity) -> Unit) : RecyclerView.ViewHolder(view) {

    private val binding = PhotoItemBinding.bind(view)

    fun bind(photos: PhotoInfoEntity) = with(binding) {
        Glide.with(root.context).load(photoBaseUrl + photos.image.name).into(ivItem)
        binding.root.setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                callback.invoke(photos)
            }
        }
    }

    companion object {
        const val photoBaseUrl = "https://gallery.prod1.webant.ru/media/"
    }
}