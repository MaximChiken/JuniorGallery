package com.example.juniorgallery.fragments.homefragments

import com.example.juniorgallery.base.base_mvp.BaseView
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface HomeView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun updateFragment(photo: List<PhotoInfoScreenModel>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun defineFragment(photoName: String)
}