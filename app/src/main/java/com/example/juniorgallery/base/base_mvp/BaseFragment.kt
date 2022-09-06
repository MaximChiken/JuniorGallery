package com.example.juniorgallery.base.base_mvp

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.juniorgallery.R
import moxy.MvpAppCompatFragment

abstract class BaseFragment<VB : ViewBinding, P : BasePresenter<*>> : MvpAppCompatFragment(), BaseView {


    abstract var presenter: P

    private var _binding: VB? = null
    val binding: VB
        get() = _binding as VB

    private lateinit var loaderDialog: Dialog


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

    override fun navigateBack() {
        findNavController().popBackStack()
    }

    override fun setLoader(isLoading: Boolean) = Unit

    override fun showToast(message: String) = Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

    override fun showToast(@StringRes id: Int) = showToast(getString(id))

    override fun setError() = Unit

    override fun setProgressDialog() {
        loaderDialog = Dialog(requireContext())
        loaderDialog.setContentView(R.layout.layout_loader)
        loaderDialog.setCancelable(false)
        loaderDialog.show()
    }

    override fun dismissProgressDialog() {
        loaderDialog.dismiss()
    }
}