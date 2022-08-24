package com.example.juniorgallery.fragments.userfragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.domain.entities.RegistrationResponseEntity
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.adapters.photo.photouser.PhotoUserAdapter
import com.example.juniorgallery.base.base_paging.BasePagingFragment
import com.example.juniorgallery.customview.CustomAppBar
import com.example.juniorgallery.databinding.UserProfileFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class UserProfileFragment : BasePagingFragment<UserProfileFragmentBinding, UserProfilePresenter>(), UserProfileView {

    @InjectPresenter
    override lateinit var presenter: UserProfilePresenter

    @ProvidePresenter
    fun provideUserProfile() = MyApp.appComponent.provideUserProfilePresenter()

    override fun initializeBinding() = UserProfileFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.bnView)
        bottomNav?.isVisible = true
        presenter.getCurrentUser()
    }

    override fun initUserInfo(userInfo: RegistrationResponseEntity) = with(binding) {
        tvUserName.text = userInfo.username
        tvDateOfBirth.text = userInfo.birthday
    }

    override fun initializeAdapterAndRecyclerView() = PhotoUserAdapter {
        val action = UserProfileFragmentDirections.actionUserFragmentToDetailViewFragment2(
            it.name,
            it.date,
            it.description,
            it.user,
            it.image.name)
        findNavController().navigate(action)
    } to binding.rvUserPhoto

    override fun initializeViewFliper() = binding.vfUserProfile

    override fun initializeSwipeRefreshLayout() = binding.srlUserProfile

    override fun initializeProgressBar() = binding.pbUserPhoto

    override fun setUpListeners() = with(binding) {
        super.setUpListeners()
        ablUserProfile.callback = {
            when (it) {
                CustomAppBar.AppBarButtons.BUTTON_BACK ->
                    findNavController().navigate(R.id.action_global_HomeGraph)
                CustomAppBar.AppBarButtons.BUTTON_ACTION ->
                    findNavController().navigate(R.id.action_userFragment_to_userSettingsFragment)
                else -> Unit

            }
        }
    }
}