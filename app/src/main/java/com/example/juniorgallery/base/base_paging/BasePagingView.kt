package com.example.juniorgallery.base.base_paging

import com.example.juniorgallery.base.base_mvp.BaseView
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface BasePagingView : BaseView {

    @StateStrategyType(value = AddToEndSingleStrategy::class)
    fun updateList(picture: List<PhotoInfoScreenModel>)

    @StateStrategyType(value = OneExecutionStateStrategy::class)
    fun isLoadingMore(bool: Boolean)
}