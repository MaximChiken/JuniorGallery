package com.example.juniorgallery.di.module

import com.example.data.managers.filemanager.FileManager
import com.example.data.managers.filemanager.FileManagerImpl
import com.example.data.managers.tokenmanager.TokenManager
import com.example.data.managers.tokenmanager.TokenManagerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ManagerModule {

    @Binds
    @Singleton
    abstract fun bindTokenManager(TokenManagerImpl: TokenManagerImpl): TokenManager

    @Binds
    @Singleton
    abstract fun bindFileManager(fileManager: FileManagerImpl): FileManager
}