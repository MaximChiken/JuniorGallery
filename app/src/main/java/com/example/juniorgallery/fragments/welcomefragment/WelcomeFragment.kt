package com.example.juniorgallery.fragments.welcomefragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.databinding.FragmentWelcomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding, WelcomePresenter>(), WelcomeView {

    @InjectPresenter
    override lateinit var presenter: WelcomePresenter

    @ProvidePresenter
    fun provideWelcomePresenter() = MyApp.appComponent.provideWelcomePresenter()

    override fun initializeBinding() = FragmentWelcomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.checkAuth()
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.bnView)
        bottomNav?.isVisible = false
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