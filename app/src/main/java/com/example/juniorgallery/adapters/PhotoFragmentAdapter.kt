package com.example.juniorgallery.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.juniorgallery.fragments.newphotofragment.NewPhotoFragment
import com.example.juniorgallery.fragments.popularphotofragment.PopularPhotoFragment
import com.example.juniorgallery.fragments.popularphotofragment.PopularPhotoPresenter

class PhotoFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return if(position == 0) NewPhotoFragment.newInstance()
        else PopularPhotoFragment.newInstance()
    }

    override fun getItemCount(): Int = 2
}