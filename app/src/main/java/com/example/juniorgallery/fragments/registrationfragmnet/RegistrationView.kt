package com.example.juniorgallery.fragments.registrationfragmnet

import com.example.juniorgallery.base.base_mvp.BaseView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface RegistrationView : BaseView {


    @StateStrategyType(OneExecutionStateStrategy::class)
    fun checkUserName(errorText: Int?)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun checkEmail(errorText: Int?)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun checkPassword(errorText: Int?)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun checkConfirmPassword(errorText: Int?)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun successRegistration()
}