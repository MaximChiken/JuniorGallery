package com.example.juniorgallery.fragments.popularphotofragment

import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.adapters.photo.photohome.PhotoHomeAdapter
import com.example.juniorgallery.base.base_paging.BasePagingFragment
import com.example.juniorgallery.databinding.FragmentPhotoBinding
import com.example.juniorgallery.fragments.homefragments.HomeFragmentDirections.actionHomeFragmentToDetailViewFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class PopularPhotoFragment : BasePagingFragment<FragmentPhotoBinding, PopularPhotoPresenter>(),
    PopularPhotoView {

    @InjectPresenter
    override lateinit var presenter: PopularPhotoPresenter

    @ProvidePresenter
    fun providePopularPresenter() = MyApp.appComponent.providePopularPhotoPresenter()

    override fun initializeBinding() = FragmentPhotoBinding.inflate(layoutInflater)

    override fun initializeAdapterAndRecyclerView() = PhotoHomeAdapter {
        val action = actionHomeFragmentToDetailViewFragment(it)
        findNavController().navigate(action)
    } to binding.rcView

    override fun initializeViewFliper() = binding.vfPhoto

    override fun initializeSwipeRefreshLayout() = binding.srlPhoto

    override fun initializeProgressBar() = binding.pbPhoto

    companion object {
        fun newInstance() = PopularPhotoFragment()
    }
}