package com.example.juniorgallery.base.base_mvp

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface BaseView:MvpView {

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun toastSuccess()

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun setError()

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun setToken(token: String)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun setLoader(isLoading: Boolean)
}