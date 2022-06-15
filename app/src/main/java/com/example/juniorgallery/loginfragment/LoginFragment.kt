package com.example.juniorgallery.loginfragment

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.databinding.LoginFragmentBinding
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class LoginFragment: BaseFragment<LoginFragmentBinding, LoginPresenter>(), LoginView {

    @InjectPresenter
    override lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun provideLoginPresenter() = MyApp.appComponent.provideLoginPresenter()

    override fun initializeBinding() = LoginFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            signUpButton.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
            }

            cancelButton.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            }

            /*signInButton.setOnClickListener {

            }*/
        }
    }



}