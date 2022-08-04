package com.example.juniorgallery.fragments.welcomefragment

import com.example.juniorgallery.base.base_mvp.BaseView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface WelcomeView: BaseView {

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun navigateToHome()
}