package com.example.juniorgallery.di.module

import com.example.data.api.AuthApi
import com.example.data.api.MediaObjectApi
import com.example.data.api.PhotoApi
import com.example.data.api.UserApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun providePhotoApi(retrofit: Retrofit): PhotoApi = retrofit.create(PhotoApi::class.java)

    @Provides
    @Singleton
    fun provideMediaObject(retrofit: Retrofit): MediaObjectApi = retrofit.create(MediaObjectApi::class.java)
}