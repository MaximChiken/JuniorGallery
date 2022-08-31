package com.example.juniorgallery.fragments.addphotofragment

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.BuildConfig
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.R
import com.example.juniorgallery.base.base_mvp.BaseFragment
import com.example.juniorgallery.customview.CustomAppBar
import com.example.juniorgallery.databinding.FragmentAddPhotoBinding
import com.example.juniorgallery.utils.TakePictureWithUriReturnContract
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import java.io.File


class AddPhotoFragment : BaseFragment<FragmentAddPhotoBinding, AddPhotoPresenter>(), AddPhotoView {

    @InjectPresenter
    override lateinit var presenter: AddPhotoPresenter

    @ProvidePresenter
    fun provideAddPhotoPresenter() = MyApp.appComponent.provideAddPhotoPresenter()

    override fun initializeBinding() = FragmentAddPhotoBinding.inflate(layoutInflater)

    private val selectImageFromGallery = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.ivImage.setImageURI(it)
    }

    private val takeImageWithCamera =
        registerForActivityResult(TakePictureWithUriReturnContract()) { (isSuccess, imageUri) ->
            if (isSuccess) {
                binding.ivImage.setImageURI(imageUri)
            }
        }

    //gallery code = 1000
    override fun setUpListeners() = with(binding) {
        ivImage.setOnClickListener {
            onAddAttachmentClick()
        }
        ablAddPhoto.callback = {
            when (it) {
                CustomAppBar.AppBarButtons.BUTTON_ACTION -> presenter.sendImage(ivImage.drawable.toBitmap())
                else -> Unit
            }
        }
    }

    private fun onAddAttachmentClick() {
        MaterialAlertDialogBuilder(requireContext(), R.style.ThemeOverlay_MaterialComponents_Dialog_Alert)
            .setTitle(R.string.choose_method)
            .setPositiveButton(R.string.take_photo) { _, _ ->
                takeImage()
            }.setNegativeButton(R.string.choose_from_gallery) { _, _ ->
                selectImageFromGallery.launch("image/*")
            }.show()
    }

    private fun takeImage() {
        lifecycleScope.launchWhenStarted {
            getTmpFileUri().let { uri -> takeImageWithCamera.launch(uri) }
        }
    }

    private fun getTmpFileUri(): Uri {
        val tmpFile = File.createTempFile("tmp_image_file", ".png",
            context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)).apply {
            createNewFile()
            deleteOnExit()
        }
        return FileProvider.getUriForFile(requireContext(), "${BuildConfig.APPLICATION_ID}.provider", tmpFile)
    }
}