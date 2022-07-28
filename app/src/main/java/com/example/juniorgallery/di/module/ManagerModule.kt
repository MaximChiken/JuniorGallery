package com.example.juniorgallery.di.module

import com.example.data.managers.TokenManager
import com.example.data.managers.TokenManagerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ManagerModule {

    @Binds
    @Singleton
    abstract fun bindTokenManager(TokenManagerImpl: TokenManagerImpl): TokenManager
}