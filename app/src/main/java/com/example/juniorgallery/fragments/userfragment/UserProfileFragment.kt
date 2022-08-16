package com.example.juniorgallery.fragments.userfragment

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.databinding.UserProfileFragmentBinding
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class UserProfileFragment : BaseFragment<UserProfileFragmentBinding, UserProfilePresenter>(), UserProfileView {

    @InjectPresenter
    override lateinit var presenter: UserProfilePresenter

    @ProvidePresenter
    fun provideUserProfile() = MyApp.appComponent.provideUserProfilePresenter()

    override fun initializeBinding() = UserProfileFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogout.setOnClickListener {
            presenter.clearData()
            navigateBack()
        }

        binding.Id.setOnClickListener {
            presenter.getCurrentUser()
        }
        binding.tvSendSms.setOnClickListener {
            setSmsTimer()
        }
    }

    override fun setId(id: Int) {
        binding.tvUserId.setText(id.toString())
    }

    override fun navigateBack() {
        findNavController().navigate(R.id.action_global_registrationGraph)
    }

    override fun setSmsTimer(): Unit = with(binding) {
        tvSendSms.setTextColor(ContextCompat.getColor(
            requireContext(),
            R.color.gray))
        tvSendSms.isClickable = false

        object : CountDownTimer(60000, 1000) {
            override fun onTick(milliseconds: Long) {
                tvSendSms.text = getString(R.string.birthdayd).format(milliseconds / 1000)
            }

            override fun onFinish() {
                tvSendSms.text = "asasdasdasd"
                tvSendSms.isClickable = true
            }
        }.start()
    }
}