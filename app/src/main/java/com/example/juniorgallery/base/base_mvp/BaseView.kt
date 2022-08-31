package com.example.juniorgallery.base.base_mvp

import androidx.annotation.StringRes
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface BaseView:MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showToast(@StringRes id: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showToast(message:String)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setError()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun setLoader(isLoading: Boolean)
}