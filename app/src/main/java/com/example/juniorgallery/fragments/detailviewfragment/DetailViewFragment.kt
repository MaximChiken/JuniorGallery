package com.example.juniorgallery.fragments.detailviewfragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            Glide.with(requireContext()).load(photoBaseUrl + args.photoScreenModel.image).into(ivDetailPhoto)
            tvPhotoDate.text = args.photoScreenModel.date.substring(0, 10)
            tvPhotoDescription.text = args.photoScreenModel.description
            tvPhotoName.text = args.photoScreenModel.name
            if (args.photoScreenModel.user != " ") {
                val id = args.photoScreenModel.user.substring(11)
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