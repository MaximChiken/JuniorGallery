package com.example.juniorgallery.base.base_mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import moxy.MvpAppCompatFragment

abstract class BaseFragment<VB : ViewBinding, P : BasePresenter<*>> : MvpAppCompatFragment() {


    abstract var presenter: P

    private var _binding: VB? = null
    val binding: VB
        get() = _binding as VB


    abstract fun initializeBinding(): VB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = initializeBinding()
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}