package com.example.juniorgallery.fragments.usersettings

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.customview.CustomAppBar
import com.example.juniorgallery.databinding.UserSettingsFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class UserSettingsFragment : BaseFragment<UserSettingsFragmentBinding, UserSettingsPresenter>(), UserSettingsView {

    @InjectPresenter
    override lateinit var presenter: UserSettingsPresenter

    @ProvidePresenter
    fun provideLoginPresenter() = MyApp.appComponent.provideUserSettingsPresenter()

    override fun initializeBinding() = UserSettingsFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.bnView)
        bottomNav?.isVisible = false
    }

    override fun setUpListeners() = with(binding) {
        tvSignOut.setOnClickListener {
            presenter.clearData()
            navigateBack()
        }
        ablUSerSettings.callback = {
            when (it) {
                CustomAppBar.AppBarButtons.BUTTON_CANCEL -> findNavController().popBackStack()
                else -> Unit
            }
        }
    }

    override fun navigateBack() = findNavController().navigate(R.id.action_global_registrationGraph)

}