package com.example.juniorgallery.fragments.homefragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.databinding.HomeFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class HomeFragment : BaseFragment<HomeFragmentBinding, HomePresenter>(), HomeView {

    @InjectPresenter
    override lateinit var presenter: HomePresenter

    @ProvidePresenter
    fun provideRegistrationPresenter() = MyApp.appComponent.provideHomePresenter()

    override fun initializeBinding() = HomeFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogout.setOnClickListener {
            presenter.clearData()
            navigateBack()
        }

        binding.Id.setOnClickListener {
            presenter.getCurrentUser()
        }
        binding.tvSendSms.setOnClickListener{
            setSmsTimer()
        }
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.bnView)
        bottomNav?.isVisible = true
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
                val seconds = milliseconds / 1000
                tvSendSms.text = "Повторить сообщение ($seconds)"
            }

            override fun onFinish() {
                tvSendSms.setText("asasdasdasd")
                tvSendSms.isClickable = true
            }
        }.start()
    }
}