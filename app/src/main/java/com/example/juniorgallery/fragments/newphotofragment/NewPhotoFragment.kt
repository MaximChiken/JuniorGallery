package com.example.juniorgallery.fragments.newphotofragment

import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.adapters.photo.PhotoAdapter
import com.example.juniorgallery.base.base_paging.BasePagingFragment
import com.example.juniorgallery.databinding.PhotoFragmentBinding
import com.example.juniorgallery.fragments.homefragments.HomeFragmentDirections
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class NewPhotoFragment : BasePagingFragment<PhotoFragmentBinding, NewPhotoPresenter>(),
    NewPhotoView {

    @InjectPresenter
    override lateinit var presenter: NewPhotoPresenter

    @ProvidePresenter
    fun provideNewPresenter() = MyApp.appComponent.provideNewPhotoPresenter()

    override fun initializeBinding() = PhotoFragmentBinding.inflate(layoutInflater)

    override fun initializeAdapterAndRecyclerView() = PhotoAdapter {
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
        fun newInstance() = NewPhotoFragment()
    }
}