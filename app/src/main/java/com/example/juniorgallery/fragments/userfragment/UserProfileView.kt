package com.example.juniorgallery.fragments.userfragment

import com.example.domain.entities.UserEntity
import com.example.juniorgallery.base.base_paging.BasePagingView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface UserProfileView : BasePagingView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun initUserInfo(userInfo: UserEntity)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun enableSetting(enable: Boolean)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateToSettings()
}