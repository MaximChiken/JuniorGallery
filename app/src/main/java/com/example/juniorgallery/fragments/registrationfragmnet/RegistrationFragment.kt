package com.example.juniorgallery.fragments.registrationfragmnet

import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.customview.CustomAppBar
import com.example.juniorgallery.databinding.RegistrationFragmentBinding
import com.example.juniorgallery.masks.DateMask
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class RegistrationFragment : BaseFragment<RegistrationFragmentBinding, RegistrationPresenter>(),
    RegistrationView {

    @InjectPresenter
    override lateinit var presenter: RegistrationPresenter

    @ProvidePresenter
    fun provideRegistrationPresenter() = MyApp.appComponent.provideRegistrationPresenter()

    override fun initializeBinding() = RegistrationFragmentBinding.inflate(layoutInflater)

    override fun setUpListeners() {
        with(binding) {
            tvToSignIn.setOnClickListener {
                findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
            }

            ablRegistration.callback = {
                when (it) {
                    CustomAppBar.AppBarButtons.BUTTON_CANCEL ->
                        findNavController().navigate(R.id.action_registrationFragment_to_welcomeFragment)
                    else -> Unit
                }
            }

            DateMask(etBirthday).listen()

            btnSignUp.setOnClickListener {
                val usernameToText = etUserName.text.toString()
                var dateOfBirth = etBirthday.text.toString()
                if (dateOfBirth == "") dateOfBirth = "00/00/0001"
                val emailToText = etEmailSignUp.text.toString()
                val passwordToText = etPasswordSignUp.text.toString()
                val confirmPasswordToText = etConfirmPassword.text.toString()
                presenter.proceedRegistration(
                    usernameToText,
                    dateOfBirth,
                    emailToText,
                    passwordToText,
                    confirmPasswordToText)
            }
        }
    }

    override fun setLoader(isLoading: Boolean) {
        binding.pbRegistration.isVisible = isLoading
    }

    override fun successRegistration() {
        findNavController().navigate(R.id.action_global_HomeGraph)
    }

    override fun checkUserName(errorText: Int?) = with(binding.tilUserName) {
        error = errorText?.let { getString(it).ifEmpty { null } }
    }

    override fun checkEmail(errorText: Int?) = with(binding.tilEmailRegistration) {
        error = errorText?.let { getString(it).ifEmpty { null } }
    }

    override fun checkPassword(errorText: Int?) = with(binding.tilPasswordSignUp) {
        error = errorText?.let { getString(it).ifEmpty { null } }
    }

    override fun checkConfirmPassword(errorText: Int?) = with(binding.tilConfirmPassword) {
        error = errorText?.let { getString(it).ifEmpty { null } }
    }
}