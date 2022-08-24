package com.example.juniorgallery.fragments.loginfragment

import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.customview.CustomAppBar
import com.example.juniorgallery.databinding.LoginFragmentBinding
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class LoginFragment : BaseFragment<LoginFragmentBinding, LoginPresenter>(), LoginView {

    @InjectPresenter
    override lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun provideLoginPresenter() = MyApp.appComponent.provideLoginPresenter()

    override fun initializeBinding() = LoginFragmentBinding.inflate(layoutInflater)

    override fun setUpListeners() {
        with(binding) {
            tvToSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
            }

            ablLogin.callback = {
                when (it) {
                    CustomAppBar.AppBarButtons.BUTTON_CANCEL ->
                        findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
                    else -> Unit
                }
            }

            btnSignIn.setOnClickListener {
                val usernameToText = etUsernameSignIn.text.toString()
                val password = etPasswordSignIn.text.toString()
                presenter.proceedLogin(usernameToText, password)
            }
        }
    }

    override fun setError() = with(binding) {
        tilUserNameLogin.error = getString(R.string.incorrect_username)
        tilPasswordLogin.error = getString(R.string.incorrect_password)
    }

    override fun successLogin() {
        findNavController().navigate(R.id.action_global_HomeGraph)
    }

    override fun setLoader(isLoading: Boolean) {
        binding.pbLogin.isVisible = isLoading
    }

}