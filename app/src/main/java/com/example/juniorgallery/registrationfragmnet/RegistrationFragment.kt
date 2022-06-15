package com.example.juniorgallery.registrationfragmnet

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
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

            birthdayEditText.addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    presenter.setBirthDateMask(s)
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            })

            signUpButton.setOnClickListener {
                val usernameToText = userNameEditText.text.toString()
                val dateOfBirth = birthdayEditText.text.toString()
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

    override fun setBirthdate(date: String, sel: Int) {
        with(binding) {
            birthdayEditText.setText(date)
            birthdayEditText.setSelection(if (sel < date.length) sel
            else date.length)
        }
    }

    override fun checkUserName(boolean: Boolean) {
        if (boolean) {
            binding.userNameInputLayout.error = null
        } else {
            binding.userNameInputLayout.error = getString(R.string.no_user_name)
        }
    }

    override fun checkEmail(boolean: Boolean) {
        if (boolean) {
            binding.emailRegistrationInputLayout.error = null
        } else {
            binding.emailRegistrationInputLayout.error = getString(R.string.no_email)
        }
    }

    override fun checkPassword(boolean: Boolean) {
        if (boolean) {
            binding.passwordInputLayout.error = null
        } else {
            binding.passwordInputLayout.error = getString(R.string.no_password)
        }
    }

    override fun checkConfirmPassword(boolean: Boolean) {
        if (boolean) {
            binding.confirmInputLayout.error = null
        } else {
            binding.confirmInputLayout.error = getString(R.string.no_confirm_password)
        }
    }

    override fun toast() {
        Toast.makeText(context, "Все отлично", Toast.LENGTH_SHORT).show()
    }

}




