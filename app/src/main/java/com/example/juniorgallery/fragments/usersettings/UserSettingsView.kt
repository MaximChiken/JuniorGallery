package com.example.juniorgallery.fragments.usersettings

import com.example.juniorgallery.base.base_mvp.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface UserSettingsView:BaseView {

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun navigateBack()

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun initSettingsInfo()

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun navigateToUserProfile()

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun checkUserName(errorText: Int?)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun checkEmail(errorText: Int?)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun checkPassword(errorText: Int?)
}