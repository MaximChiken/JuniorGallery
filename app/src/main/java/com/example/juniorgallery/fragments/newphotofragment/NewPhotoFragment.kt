package com.example.juniorgallery.fragments.newphotofragment

import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.adapters.photo.photohome.PhotoHomeAdapter
import com.example.juniorgallery.base.base_paging.BasePagingFragment
import com.example.juniorgallery.databinding.FragmentPhotoBinding
import com.example.juniorgallery.fragments.homefragments.HomeFragmentDirections.actionHomeFragmentToDetailViewFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class NewPhotoFragment : BasePagingFragment<FragmentPhotoBinding, NewPhotoPresenter>(),
    NewPhotoView {

    @InjectPresenter
    override lateinit var presenter: NewPhotoPresenter

    @ProvidePresenter
    fun provideNewPresenter() = MyApp.appComponent.provideNewPhotoPresenter()

    override fun initializeBinding() = FragmentPhotoBinding.inflate(layoutInflater)

    override fun initializeAdapterAndRecyclerView() = PhotoHomeAdapter {
        val action = actionHomeFragmentToDetailViewFragment(it)
        findNavController().navigate(action)
    } to binding.rcView

    override fun initializeViewFliper() = binding.vfPhoto

    override fun initializeSwipeRefreshLayout() = binding.srlPhoto

    override fun initializeProgressBar() = binding.pbPhoto

    companion object {
        fun newInstance() = NewPhotoFragment()
    }
}