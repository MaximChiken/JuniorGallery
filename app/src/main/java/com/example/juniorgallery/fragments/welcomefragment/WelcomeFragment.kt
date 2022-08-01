package com.example.juniorgallery.fragments.welcomefragment

import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.databinding.WelcomeFragmentBinding
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class WelcomeFragment : BaseFragment<WelcomeFragmentBinding, WelcomePresenter>(), WelcomeView {

    @InjectPresenter
    override lateinit var presenter: WelcomePresenter

    @ProvidePresenter
    fun provideWelcomePresenter() = MyApp.appComponent.provideWelcomePresenter()

    override fun initializeBinding() = WelcomeFragmentBinding.inflate(layoutInflater)

    override fun setUpListeners() {
        with(binding) {
            createAccount.setOnClickListener {
                findNavController().navigate(R.id.action_welcomeFragment_to_registrationFragment)
            }

            haveAccount.setOnClickListener {
                findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
            }
        }
    }

}