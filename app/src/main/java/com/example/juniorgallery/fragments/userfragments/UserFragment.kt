package com.example.juniorgallery.fragments.userfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.juniorgallery.databinding.UserFragmentBinding

class UserFragment : Fragment() {
    private lateinit var binding: UserFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = UserFragmentBinding.inflate(layoutInflater)

        return binding.root
    }
}