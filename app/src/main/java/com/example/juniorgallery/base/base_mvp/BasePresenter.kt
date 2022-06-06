package com.example.juniorgallery.base.base_mvp

import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
abstract class BasePresenter<T:BaseView>: MvpPresenter<T>() {
}