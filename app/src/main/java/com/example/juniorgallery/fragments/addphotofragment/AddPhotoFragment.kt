package com.example.juniorgallery.fragments.addphotofragment

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.customview.CustomAppBar
import com.example.juniorgallery.databinding.FragmentAddPhotoBinding
import com.example.juniorgallery.fragments.addphotofragment.AddPhotoFragmentDirections.actionAddPhotoFragmentToDetailViewFragment3
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel
import com.example.juniorgallery.utils.getString
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class AddPhotoFragment : BaseFragment<FragmentAddPhotoBinding, AddPhotoPresenter>(), AddPhotoView {

    private val args: AddPhotoFragmentArgs by navArgs()

    @InjectPresenter
    override lateinit var presenter: AddPhotoPresenter

    @ProvidePresenter
    fun provideAddPhotoPresenter() = MyApp.appComponent.provideAddPhotoPresenter()

    override fun initializeBinding() = FragmentAddPhotoBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initScreen()
    }

    override fun setUpListeners() = with(binding) {
        ablAddPhoto.callback = {
            when (it) {
                CustomAppBar.AppBarButtons.BUTTON_ACTION -> checkImageData()
                CustomAppBar.AppBarButtons.BUTTON_BACK -> navigateBack()
                else -> Unit
            }
        }
    }

    override fun initScreen() {
        binding.ivImage.setImageURI(args.photoUri.toUri())
        presenter.onImageTaken(args.photoFile.takenPhoto)
    }


    override fun navigateToNewPhoto(photoInfoScreenModel: PhotoInfoScreenModel) {
        val action = actionAddPhotoFragmentToDetailViewFragment3(photoInfoScreenModel)
        findNavController().navigate(action)
    }

    private fun checkImageData() = with(binding) {
        tilName.error = null
        when {
            etName.getString().isEmpty() -> tilName.error = getString(R.string.empty_name)
            (!scNew.isChecked && !scPopular.isChecked) -> showToast(R.string.not_new_or_popular)
            else -> presenter.sendImage(
                etName.getString(),
                etDescription.getString().trim(' '),
                scNew.isChecked,
                scPopular.isChecked)
        }
    }
}