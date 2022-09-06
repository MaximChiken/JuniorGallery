package com.example.juniorgallery.fragments.userfragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.domain.entities.UserEntity
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.adapters.photo.photouser.PhotoUserAdapter
import com.example.juniorgallery.base.base_paging.BasePagingFragment
import com.example.juniorgallery.customview.CustomAppBar
import com.example.juniorgallery.databinding.FragmentUserProfileBinding
import com.example.juniorgallery.fragments.userfragment.UserProfileFragmentDirections.actionUserFragmentToDetailViewFragment2
import com.example.juniorgallery.fragments.userfragment.UserProfileFragmentDirections.actionUserFragmentToUserSettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class UserProfileFragment : BasePagingFragment<FragmentUserProfileBinding, UserProfilePresenter>(), UserProfileView {

    private lateinit var userFullInfo: UserEntity

    @InjectPresenter
    override lateinit var presenter: UserProfilePresenter

    @ProvidePresenter
    fun provideUserProfile() = MyApp.appComponent.provideUserProfilePresenter()

    override fun initializeBinding() = FragmentUserProfileBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.bnView)
        bottomNav?.isVisible = true
    }

    override fun initUserInfo(userInfo: UserEntity) = with(binding) {
        userFullInfo = userInfo
        tvUserName.text = userInfo.username
        tvDateOfBirth.text = userInfo.birthday
    }

    override fun initializeAdapterAndRecyclerView() = PhotoUserAdapter {
        val action = actionUserFragmentToDetailViewFragment2(it)
        findNavController().navigate(action)
    } to binding.rvUserPhoto

    override fun initializeViewFliper() = binding.vfUserProfile

    override fun initializeSwipeRefreshLayout() = binding.srlUserProfile

    override fun initializeProgressBar() = binding.pbUserPhoto

    override fun setUpListeners() = with(binding) {
        super.setUpListeners()
        ablUserProfile.callback = {
            when (it) {
                CustomAppBar.AppBarButtons.BUTTON_BACK -> navigateBack()
                CustomAppBar.AppBarButtons.BUTTON_ACTION -> navigateToSettings()
                else -> Unit
            }
        }
    }

    override fun enableSetting(enable: Boolean) = binding.ablUserProfile.enableEndIcon(enable)

    override fun navigateToSettings() = with(userFullInfo) {
        val action = actionUserFragmentToUserSettingsFragment(username, birthday, email, id)
        findNavController().navigate(action)
    }
}