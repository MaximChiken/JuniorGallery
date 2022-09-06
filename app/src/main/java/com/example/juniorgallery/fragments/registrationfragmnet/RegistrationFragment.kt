package com.example.juniorgallery.fragments.registrationfragmnet

import androidx.navigation.fragment.findNavController
import com.example.domain.entities.RegistrationEntity
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.customview.CustomAppBar
import com.example.juniorgallery.databinding.FragmentRegistrationBinding
import com.example.juniorgallery.fragments.registrationfragmnet.RegistrationFragmentDirections.*
import com.example.juniorgallery.utils.DateMask
import com.example.juniorgallery.utils.getString
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class RegistrationFragment : BaseFragment<FragmentRegistrationBinding, RegistrationPresenter>(),
    RegistrationView {

    @InjectPresenter
    override lateinit var presenter: RegistrationPresenter

    @ProvidePresenter
    fun provideRegistrationPresenter() = MyApp.appComponent.provideRegistrationPresenter()

    override fun initializeBinding() = FragmentRegistrationBinding.inflate(layoutInflater)

    override fun setUpListeners() {
        with(binding) {
            tvToSignIn.setOnClickListener {
                findNavController().navigate(actionRegistrationFragmentToLoginFragment())
            }

            ablRegistration.callback = {
                when (it) {
                    CustomAppBar.AppBarButtons.BUTTON_CANCEL ->
                        findNavController().navigate(actionRegistrationFragmentToWelcomeFragment())
                    else -> Unit
                }
            }

            DateMask(etBirthday).listen()

            btnSignUp.setOnClickListener {
                val username = etUserName.getString()
                val dateOfBirth = etBirthday.getString()
                val email = etEmailSignUp.getString()
                val password = etPasswordSignUp.getString()
                val confirmPassword = etConfirmPassword.getString()
                presenter.proceedRegistration(
                    RegistrationEntity(email, dateOfBirth, username, password),
                    confirmPassword
                )
            }
        }
    }

    override fun successRegistration() {
        findNavController().navigate(actionRegistrationFragmentToHomeGraph())
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