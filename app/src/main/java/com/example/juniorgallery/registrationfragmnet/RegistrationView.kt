package com.example.juniorgallery.registrationfragmnet

import com.example.juniorgallery.base.base_mvp.BaseView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface RegistrationView : BaseView {

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun setBirthdate(date: String, sel: Int)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun checkUserName(boolean: Boolean)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun checkEmail(boolean: Boolean)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun checkPassword(boolean: Boolean)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun checkConfirmPassword(boolean: Boolean)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun toast()

}