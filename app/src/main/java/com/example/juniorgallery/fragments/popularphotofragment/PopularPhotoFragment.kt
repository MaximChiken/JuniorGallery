package com.example.juniorgallery.fragments.popularphotofragment

import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.adapters.photo.photohome.PhotoHomeAdapter
import com.example.juniorgallery.base.base_paging.BasePagingFragment
import com.example.juniorgallery.databinding.PhotoFragmentBinding
import com.example.juniorgallery.fragments.homefragments.HomeFragmentDirections
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class PopularPhotoFragment : BasePagingFragment<PhotoFragmentBinding, PopularPhotoPresenter>(),
    PopularPhotoView {

    @InjectPresenter
    override lateinit var presenter: PopularPhotoPresenter

    @ProvidePresenter
    fun providePopularPresenter() = MyApp.appComponent.providePopularPhotoPresenter()

    override fun initializeBinding() = PhotoFragmentBinding.inflate(layoutInflater)

    override fun initializeAdapterAndRecyclerView() = PhotoHomeAdapter {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailViewFragment(
            it.name,
            it.date,
            it.description,
            it.user,
            it.image.name)
        findNavController().navigate(action)
    } to binding.rcView

    override fun initializeViewFliper() = binding.vfPhoto

    override fun initializeSwipeRefreshLayout() = binding.srlPhoto

    override fun initializeProgressBar() = binding.pbPhoto

    companion object {
        fun newInstance() = PopularPhotoFragment()
    }
}