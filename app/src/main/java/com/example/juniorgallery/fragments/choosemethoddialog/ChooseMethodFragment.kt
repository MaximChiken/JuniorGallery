package com.example.juniorgallery.fragments.choosemethoddialog

import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.navigation.fragment.findNavController
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.base.base_mvp_bottomsheet.MvpBottomSheetFragment
import com.example.juniorgallery.databinding.LayoutBottomSheetBinding
import com.example.juniorgallery.fragments.choosemethoddialog.ChooseMethodFragmentDirections.actionBottomSheetDialogFragmentToAddPhotoFragment
import com.example.juniorgallery.screenviewmodels.TakenPhotoScreenModel
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import java.io.File

class ChooseMethodFragment : MvpBottomSheetFragment<LayoutBottomSheetBinding, ChooseMethodPresenter>(),
    ChooseMethodView {

    @InjectPresenter
    override lateinit var presenter: ChooseMethodPresenter

    @ProvidePresenter
    fun provideAddPhotoPresenter() = MyApp.appComponent.provideChooseMethodPresenter()

    override fun initializeBinding() = LayoutBottomSheetBinding.inflate(layoutInflater)

    private val selectImageFromGallery = registerForActivityResult(ActivityResultContracts.GetContent()) {
        if (it != null) {
            presenter.onImageSelected(it)
        }
    }

    private val takeImageWithCamera = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        presenter.onImageCaptured(it)
    }

    override fun updateImage(currentImageUri: Uri, takenPhotoScreenModel: TakenPhotoScreenModel) {
        findNavController().navigate(actionBottomSheetDialogFragmentToAddPhotoFragment(
            currentImageUri.toString(), takenPhotoScreenModel))
    }

    override fun setUpListeners() = with(binding) {
        llChoosePhoto.setOnClickListener {
            selectImageFromGallery.launch("image/*")
        }
        llTakePhoto.setOnClickListener {
            presenter.onCaptureTaken()
        }
    }

    override fun captureImage(file: File) {
        takeImageWithCamera.launch(
            FileProvider.getUriForFile(
                requireContext(),
                requireContext().applicationContext.packageName + ".provider",
                file
            )
        )
    }
}