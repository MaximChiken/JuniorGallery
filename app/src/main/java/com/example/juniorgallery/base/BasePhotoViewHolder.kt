package com.example.juniorgallery.base

import android.content.Context
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.domain.entities.PhotoInfoEntity

abstract class BasePhotoViewHolder(
    binding: ViewBinding,
    private val callback: (PhotoInfoEntity) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    protected val context: Context = binding.root.context

    private lateinit var imageView: AppCompatImageView

    abstract fun initializeImageView(): AppCompatImageView

    fun bind(photos: PhotoInfoEntity) {
        imageView = initializeImageView()
        Glide.with(context).load(photoBaseUrl + photos.image.name).into(imageView)
        imageView.setOnClickListener {
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