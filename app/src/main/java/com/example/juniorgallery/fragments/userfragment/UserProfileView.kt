package com.example.juniorgallery.fragments.userfragment

import com.example.domain.entities.RegistrationResponseEntity
import com.example.juniorgallery.base.base_mvp.BaseView
import com.example.juniorgallery.base.base_paging.BasePagingView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface UserProfileView : BasePagingView {

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun initUserInfo(userInfo: RegistrationResponseEntity)
}