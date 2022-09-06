package com.example.juniorgallery.fragments.addphotofragment

import com.example.juniorgallery.base.base_mvp.BaseView
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface AddPhotoView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun initScreen()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateToNewPhoto(photoInfoScreenModel: PhotoInfoScreenModel)
}