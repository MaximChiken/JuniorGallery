package com.example.juniorgallery.fragments.homefragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.databinding.HomeFragmentBinding
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class HomeFragment : BaseFragment<HomeFragmentBinding, HomePresenter>(), HomeView {

    @InjectPresenter
    override lateinit var presenter: HomePresenter

    @ProvidePresenter
    fun provideRegistrationPresenter() = MyApp.appComponent.provideHomePresenter()

    override fun initializeBinding() = HomeFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.checkAuth()
        binding.btnLogout.setOnClickListener {
            presenter.clearData()
            navigateBack()
        }
    }

    override fun navigateBack() {
        findNavController().navigate(R.id.action_global_registrationGraph)
    }
}