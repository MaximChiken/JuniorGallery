package com.example.juniorgallery.fragments.loginfragment

import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.customview.CustomAppBar
import com.example.juniorgallery.databinding.FragmentLoginBinding
import com.example.juniorgallery.fragments.loginfragment.LoginFragmentDirections.*
import com.example.juniorgallery.utils.getString
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginPresenter>(), LoginView {

    @InjectPresenter
    override lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun provideLoginPresenter() = MyApp.appComponent.provideLoginPresenter()

    override fun initializeBinding() = FragmentLoginBinding.inflate(layoutInflater)

    override fun setUpListeners() {
        with(binding) {
            tvToSignUp.setOnClickListener {
                findNavController().navigate(actionLoginFragmentToRegistrationFragment())
            }

            ablLogin.callback = {
                when (it) {
                    CustomAppBar.AppBarButtons.BUTTON_CANCEL ->
                        findNavController().navigate(actionLoginFragmentToWelcomeFragment())
                    else -> Unit
                }
            }

            btnSignIn.setOnClickListener {
                val usernameToText = etUsernameSignIn.getString()
                val password = etPasswordSignIn.getString()
                presenter.proceedLogin(usernameToText, password)
            }
        }
    }

    override fun setError() = with(binding) {
        tilUserNameLogin.error = getString(R.string.incorrect_username)
        tilPasswordLogin.error = getString(R.string.incorrect_password)
    }

    override fun successLogin() {
        findNavController().navigate(actionLoginFragmentToHomeGraph())
    }
}