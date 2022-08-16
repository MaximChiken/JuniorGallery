package com.example.juniorgallery.fragments.userfragment

import com.example.juniorgallery.base.base_mvp.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface UserProfileView : BaseView {

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun navigateBack()

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun setId(id: Int)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setSmsTimer()
}