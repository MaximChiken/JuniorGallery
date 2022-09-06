package com.example.juniorgallery.fragments.detailviewfragment

import com.example.juniorgallery.base.base_mvp.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface DetailViewView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setUserName(username: String)
}