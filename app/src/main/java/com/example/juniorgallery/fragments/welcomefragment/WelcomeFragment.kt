package com.example.juniorgallery.fragments.welcomefragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.databinding.WelcomeFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class WelcomeFragment : BaseFragment<WelcomeFragmentBinding, WelcomePresenter>(), WelcomeView {

    @InjectPresenter
    override lateinit var presenter: WelcomePresenter

    @ProvidePresenter
    fun provideWelcomePresenter() = MyApp.appComponent.provideWelcomePresenter()

    override fun initializeBinding() = WelcomeFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.checkAuth()
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.bnView)
        bottomNav?.isVisible = false
        setUpListeners()
    }

    override fun setUpListeners() {
        with(binding) {
            btnCreateAccount.setOnClickListener {
                findNavController().navigate(R.id.action_welcomeFragment_to_registrationFragment)
            }

            btnHaveAccount.setOnClickListener {
                findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
            }

        }
    }

    override fun navigateToHome() {
        findNavController().navigate(R.id.action_global_HomeGraph)
    }
}