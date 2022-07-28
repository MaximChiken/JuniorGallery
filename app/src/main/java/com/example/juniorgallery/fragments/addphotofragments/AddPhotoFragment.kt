package com.example.juniorgallery.fragments.addphotofragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.juniorgallery.databinding.AddPhotoFragmentBinding

class AddPhotoFragment: Fragment() {
    private lateinit var binding: AddPhotoFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AddPhotoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
}