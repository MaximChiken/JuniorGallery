package com.example.juniorgallery.registrationfragmnet

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.masks.DateMask
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.databinding.RegistrationFragmentBinding
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class RegistrationFragment : BaseFragment<RegistrationFragmentBinding, RegistrationPresenter>(), RegistrationView {

    @InjectPresenter
    override lateinit var presenter: RegistrationPresenter

    @ProvidePresenter
    fun provideRegistrationPresenter() = MyApp.appComponent.provideRegistrationPresenter()

    override fun initializeBinding() = RegistrationFragmentBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        with(binding) {
            signInButton.setOnClickListener {
                findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
            }

            cancelButton.setOnClickListener {
                findNavController().navigate(R.id.action_registrationFragment_to_welcomeFragment)
            }

            DateMask(birthdayEditText).listen()

            signUpButton.setOnClickListener {
                val usernameToText = userNameEditText.text.toString()
                var dateOfBirth = birthdayEditText.text.toString()
                if (dateOfBirth == "") dateOfBirth = "00/00/0001"
                val emailToText = emailSignUpEditText.text.toString()
                val passwordToText = passwordSignUpEditText.text.toString()
                val confirmPasswordToText = confirmPasswordSignUpEditText.text.toString()
                presenter.proceedRegistration(
                    usernameToText,
                    dateOfBirth,
                    emailToText,
                    passwordToText,
                    confirmPasswordToText)
            }
        }
    }



    override fun checkUserName(errorText: Int?) = with(binding.userNameInputLayout) {
        error = errorText?.let { getString(it).ifEmpty { null } }

    }

    override fun checkEmail(errorText: Int?) = with(binding.emailRegistrationInputLayout) {
        error = errorText?.let { getString(it).ifEmpty { null } }
    }

    override fun checkPassword(errorText: Int?) = with(binding.passwordInputLayout) {
        error = errorText?.let { getString(it).ifEmpty { null } }

    }

    override fun checkConfirmPassword(errorText: Int?) = with(binding.confirmInputLayout) {
        error = errorText?.let { getString(it).ifEmpty { null } }
    }

    override fun toastsucc() {
        Toast.makeText(context, "Все отлично", Toast.LENGTH_SHORT).show()
    }

    override fun toasterr() {
        Toast.makeText(context, "Хуйнябля", Toast.LENGTH_SHORT).show()
    }
}




