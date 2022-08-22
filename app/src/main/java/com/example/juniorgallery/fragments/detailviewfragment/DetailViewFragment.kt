package com.example.juniorgallery.fragments.detailviewfragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.customview.CustomAppBar
import com.example.juniorgallery.databinding.DetailViewFragmentBinding
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class DetailViewFragment : BaseFragment<DetailViewFragmentBinding, DetailViewPresenter>(), DetailViewView {

    private val args: DetailViewFragmentArgs by navArgs()

    @InjectPresenter
    override lateinit var presenter: DetailViewPresenter

    @ProvidePresenter
    fun provideDetailViewPresenter() = MyApp.appComponent.provideDetailViewPresenter()

    override fun initializeBinding() = DetailViewFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            Glide.with(requireContext()).load(photoBaseUrl + args.photoName).into(ivDetailPhoto)
            tvPhotoDate.text = args.date.substring(0, 10)
            tvPhotoDescription.text = args.description
            tvPhotoName.text = args.name
            if (args.user != " ") {
                val id = args.user.substring(11)
                presenter.getUser(id)
            }
        }
    }

    override fun setUserName(username: String) {
        binding.tvUserName.text = username
    }

    override fun setUpListeners() = with(binding) {
        ablDetailView.callback = {
            when (it) {
                CustomAppBar.AppBarButtons.BUTTON_BACK -> findNavController().popBackStack()
                else -> Unit
            }
        }
    }

    companion object {
        const val photoBaseUrl = "https://gallery.prod1.webant.ru/media/"
    }
}