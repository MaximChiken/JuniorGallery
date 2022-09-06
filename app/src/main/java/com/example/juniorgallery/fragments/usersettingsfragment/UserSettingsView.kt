package com.example.juniorgallery.fragments.usersettingsfragment

import com.example.juniorgallery.base.base_mvp.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface UserSettingsView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateToRegistration()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun initSettingsInfo()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun checkUserName(errorText: Int?)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun checkEmail(errorText: Int?)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun checkPassword(errorText: Int?)
}