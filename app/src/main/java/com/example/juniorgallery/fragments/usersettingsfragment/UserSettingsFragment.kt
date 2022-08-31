package com.example.juniorgallery.fragments.usersettingsfragment

import android.app.AlertDialog
import android.os.Bundle
import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.core.text.buildSpannedString
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.domain.entities.UserEntity
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.base.extentions.getColor
import com.example.juniorgallery.base.extentions.getString
import com.example.juniorgallery.customview.CustomAppBar
import com.example.juniorgallery.databinding.FragmentUserSettingsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class UserSettingsFragment : BaseFragment<FragmentUserSettingsBinding, UserSettingsPresenter>(), UserSettingsView {

    private val args: UserSettingsFragmentArgs by navArgs()

    @InjectPresenter
    override lateinit var presenter: UserSettingsPresenter

    @ProvidePresenter
    fun provideLoginPresenter() = MyApp.appComponent.provideUserSettingsPresenter()

    override fun initializeBinding() = FragmentUserSettingsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.bnView)
        bottomNav?.isVisible = false
        initUserDeleteView()
        initSettingsInfo()
    }

    override fun initSettingsInfo() = with(binding) {
        etUserName.setText(args.username)
        etBirthday.setText(args.date)
        etEmail.setText(args.email)
    }

    override fun setUpListeners() = with(binding) {
        tvSignOut.setOnClickListener {
            presenter.clearData()
        }
        ablUserSettings.callback = {
            when (it) {
                CustomAppBar.AppBarButtons.BUTTON_CANCEL -> findNavController().popBackStack()
                CustomAppBar.AppBarButtons.BUTTON_ACTION -> updateUser()
                else -> Unit
            }
        }
    }

    override fun navigateBack() = findNavController().navigate(R.id.action_global_registrationGraph)

    override fun navigateToUserProfile() {
        findNavController().popBackStack()
    }

    private fun initUserDeleteView() = with(binding) {
        val clickableInfoText = object : ClickableSpan() {
            override fun onClick(widget: View) {
                confirmDeleteDialog(args.id)
            }
        }

        tvDeleteAccount.text = buildSpannedString {
            val resourceString = getString(R.string.delete_account)
            append(resourceString)
            setSpan(
                clickableInfoText,
                resourceString.length - "delete your account".length,
                resourceString.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            setSpan(
                ForegroundColorSpan(R.color.pink.getColor(requireContext())),
                resourceString.length - "delete your account".length,
                resourceString.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        tvDeleteAccount.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun confirmDeleteDialog(id: String) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage("Are you sure you want to delete account?")
            .setCancelable(false)
            .setPositiveButton("Yes") { _, _ ->
                presenter.deleteAccount(id)
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }

    private fun updateUser() = with(binding) {
        if (etNewPassword.text?.isNotBlank() == true && etOldPassword.text?.isNotBlank() == true) {
            presenter.updatePassword(
                args.id,
                etOldPassword.getString(),
                etNewPassword.getString(),
                etConfirmNewPassword.getString())
        }
        if (etUserName.getString() != args.username ||
            etBirthday.getString() != args.date ||
            etEmail.getString() != args.email
        ) {
            presenter.updateUserInfo(UserEntity(
                args.id,
                etEmail.getString(),
                etBirthday.getString(),
                etUserName.getString()))
        }
    }

    override fun checkUserName(errorText: Int?) = with(binding.tilUserName) {
        error = errorText?.let { getString(it).ifEmpty { null } }
    }

    override fun checkEmail(errorText: Int?) = with(binding.tilEmail) {
        error = errorText?.let { getString(it).ifEmpty { null } }
    }

    override fun checkPassword(errorText: Int?) = with(binding.tilNewPassword) {
        error = errorText?.let { getString(it).ifEmpty { null } }
    }
}