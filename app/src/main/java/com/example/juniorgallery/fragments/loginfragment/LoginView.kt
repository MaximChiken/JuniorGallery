package com.example.juniorgallery.fragments.loginfragment

import com.example.juniorgallery.base.base_mvp.BaseView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType


interface LoginView: BaseView {

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun toastsucc()

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun toasterr()
}