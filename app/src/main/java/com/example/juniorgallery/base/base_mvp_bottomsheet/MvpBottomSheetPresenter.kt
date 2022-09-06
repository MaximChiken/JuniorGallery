package com.example.juniorgallery.base.base_mvp_bottomsheet

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
abstract class MvpBottomSheetPresenter<T : MvpBottomSheetView> : MvpPresenter<T>()