package com.example.juniorgallery.fragments.loginfragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.databinding.LoginFragmentBinding
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class LoginFragment : BaseFragment<LoginFragmentBinding, LoginPresenter>(), LoginView {

    @InjectPresenter
    override lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun provideLoginPresenter() = MyApp.appComponent.provideLoginPresenter()

    override fun initializeBinding() = LoginFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvToSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
            }

            toolbarLayout.tvCancel.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            }

            btnSignIn.setOnClickListener {
                val usernameToText = etUsernameSignIn.text.toString()
                val password = etPasswordSignIn.text.toString()
                presenter.proceedLogin(usernameToText, password)
            }
        }
    }

    override fun setError() = with(binding){
        tilUserNameLogin.error = getString(R.string.incorrect_username)
        tilPasswordLogin.error = getString(R.string.incorrect_password)
    }
}