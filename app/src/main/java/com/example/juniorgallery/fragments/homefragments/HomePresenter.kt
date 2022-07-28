package com.example.juniorgallery.fragments.homefragments

import com.example.data.managers.TokenManager
import com.example.juniorgallery.base.base_mvp.BasePresenter
import javax.inject.Inject

class HomePresenter @Inject constructor(private val tokenManager: TokenManager): BasePresenter<HomeView>() {

    fun checkAuth(){
        if (tokenManager.accessToken == ""){
            viewState.navigateBack()
        }
    }

    fun clearData(){
        tokenManager.logout()

    }
}