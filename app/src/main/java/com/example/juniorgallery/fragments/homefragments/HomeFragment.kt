package com.example.juniorgallery.fragments.homefragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.adapters.PhotoFragmentAdapter
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.base.base_paging.BasePagingFragment
import com.example.juniorgallery.customview.CustomAppBar
import com.example.juniorgallery.databinding.FragmentHomeBinding
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class HomeFragment : BaseFragment<FragmentHomeBinding, HomePresenter>(), HomeView {

    @InjectPresenter
    override lateinit var presenter: HomePresenter

    @ProvidePresenter
    fun provideHomePresenter() = MyApp.appComponent.provideHomePresenter()

    private lateinit var viewPager: ViewPager2

    override fun initializeBinding() = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNav: BottomNavigationView? = activity?.findViewById(R.id.bnView)
        bottomNav?.isVisible = true

        viewPager = vpPlaceHolder
        val adapter = PhotoFragmentAdapter(this@HomeFragment)
        viewPager.adapter = adapter

        TabLayoutMediator(tlPhoto, vpPlaceHolder) { tab, position ->
            tab.text = if (position == 0) "New" else "Popular"
        }.attach()
    }

    override fun setUpListeners() = with(binding) {
        ablHome.callback = {
            when (it) {
                CustomAppBar.AppBarButtons.BUTTON_SEARCH -> defineFragment(ablHome.searchText)
                CustomAppBar.AppBarButtons.BUTTON_CROSS -> defineFragment("")
                else -> Unit
            }
        }
    }

    override fun defineFragment(photoName: String) {
        if (viewPager.currentItem == 0) {
            presenter.searchPhoto(photoName, isNew = "true")
        } else {
            presenter.searchPhoto(photoName, isPopular = "true")
        }
    }

    override fun updateFragment(photo: List<PhotoInfoScreenModel>) {
        (childFragmentManager.findFragmentByTag("f${viewPager.currentItem}") as BasePagingFragment<*, *>)
            .updateList(photo)
    }
}