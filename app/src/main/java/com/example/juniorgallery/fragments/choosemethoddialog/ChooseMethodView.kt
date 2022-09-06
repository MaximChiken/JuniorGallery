package com.example.juniorgallery.fragments.choosemethoddialog

import android.net.Uri
import com.example.juniorgallery.base.base_mvp_bottomsheet.MvpBottomSheetView
import com.example.juniorgallery.screenviewmodels.TakenPhotoScreenModel
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import java.io.File

interface ChooseMethodView : MvpBottomSheetView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun captureImage(file: File)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun updateImage(currentImageUri: Uri, takenPhotoScreenModel: TakenPhotoScreenModel)
}