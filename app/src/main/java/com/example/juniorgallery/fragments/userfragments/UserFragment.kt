package com.example.juniorgallery.fragments.userfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.data.managers.TokenManager
import com.example.juniorgallery.R
import com.example.juniorgallery.databinding.UserFragmentBinding
import javax.inject.Inject

class UserFragment : Fragment() {
    private lateinit var binding: UserFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = UserFragmentBinding.inflate(layoutInflater)

        return binding.root
    }
}