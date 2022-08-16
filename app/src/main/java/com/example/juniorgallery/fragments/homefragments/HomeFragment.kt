package com.example.juniorgallery.fragments.homefragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.adapters.PhotoFragmentAdapter
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.databinding.HomeFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class HomeFragment : BaseFragment<HomeFragmentBinding, HomePresenter>(), HomeView {

    @InjectPresenter
    override lateinit var presenter: HomePresenter

    @ProvidePresenter
    fun provideHomePresenter() = MyApp.appComponent.provideHomePresenter()


    override fun initializeBinding() = HomeFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.bnView)
        bottomNav?.isVisible = true

        val viewPager = binding.vpPlaceHolder
        val adapter = PhotoFragmentAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(binding.tlPhoto, binding.vpPlaceHolder) { tab, position ->
            tab.text = if (position == 0) "New" else "Popular"
        }.attach()
    }
}