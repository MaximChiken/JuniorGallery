package com.example.juniorgallery.fragments.homefragments

import com.example.domain.entities.PhotoInfoEntity
import com.example.juniorgallery.base.base_mvp.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface HomeView : BaseView {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun updateFragment(photo: List<PhotoInfoEntity>)

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun defineFragment(photoName: String)
}