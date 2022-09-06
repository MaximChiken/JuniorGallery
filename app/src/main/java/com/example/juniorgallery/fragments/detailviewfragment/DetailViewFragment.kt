package com.example.juniorgallery.fragments.detailviewfragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.customview.CustomAppBar
import com.example.juniorgallery.databinding.FragmentDetailViewBinding
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class DetailViewFragment : BaseFragment<FragmentDetailViewBinding, DetailViewPresenter>(), DetailViewView {

    private val args: DetailViewFragmentArgs by navArgs()

    @InjectPresenter
    override lateinit var presenter: DetailViewPresenter

    @ProvidePresenter
    fun provideDetailViewPresenter() = MyApp.appComponent.provideDetailViewPresenter()

    override fun initializeBinding() = FragmentDetailViewBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        with(args.photoScreenModel) {
            Glide.with(requireContext()).load(photoBaseUrl + image).into(ivDetailPhoto)
            tvPhotoDate.text = date.substring(0, 10)
            tvPhotoDescription.text = description
            tvPhotoName.text = name
            if (user != " ") {
                val id = user.substring(11)
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
                CustomAppBar.AppBarButtons.BUTTON_BACK -> navigateBack()
                else -> Unit
            }
        }
    }

    companion object {
        const val photoBaseUrl = "https://gallery.prod1.webant.ru/media/"
    }
}