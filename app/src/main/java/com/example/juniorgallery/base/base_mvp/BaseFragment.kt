package com.example.juniorgallery.base.base_mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import moxy.MvpAppCompatFragment

abstract class BaseFragment<VB : ViewBinding, P : BasePresenter<*>> : MvpAppCompatFragment(), BaseView {


    abstract var presenter: P

    private var _binding: VB? = null
    val binding: VB
        get() = _binding as VB


    abstract fun initializeBinding(): VB

    open fun setUpListeners() = Unit

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = initializeBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun setLoader(isLoading: Boolean) = Unit

    override fun toastSuccess() {
        Toast.makeText(context, "Все отлично", Toast.LENGTH_SHORT).show()
    }

    override fun setError() {
        Toast.makeText(context, "Хуйнябля", Toast.LENGTH_SHORT).show()
    }

    override fun setToken(token: String) {
        Toast.makeText(context, token, Toast.LENGTH_SHORT).show()
    }
}