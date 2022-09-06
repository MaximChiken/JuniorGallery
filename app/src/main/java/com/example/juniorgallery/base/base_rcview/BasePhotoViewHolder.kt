package com.example.juniorgallery.base.base_rcview

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel

abstract class BasePhotoViewHolder(
    binding: ViewBinding,
    private val callback: (PhotoInfoScreenModel) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    protected val context: Context = binding.root.context

    private lateinit var imageView: AppCompatImageView

    abstract fun initializeImageView(): AppCompatImageView

    fun bind(photos: PhotoInfoScreenModel) {
        imageView = initializeImageView()
        Glide.with(context).load(photoBaseUrl + photos.image).into(imageView)
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