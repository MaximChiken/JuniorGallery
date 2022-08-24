package com.example.juniorgallery.fragments.usersettings

import com.example.juniorgallery.base.base_mvp.BaseView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface UserSettingsView:BaseView {

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun navigateBack()
}