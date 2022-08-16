package com.example.juniorgallery.di.module

import com.example.data.base.BaseMapper
import com.example.data.mappers.LoginMapper
import com.example.data.mappers.PhotoMapper
import com.example.data.mappers.RegistrationRequestMapper
import com.example.data.mappers.RegistrationResponseMapper
import com.example.data.models.*
import com.example.domain.entities.LoginEntity
import com.example.domain.entities.PhotoEntity
import com.example.domain.entities.RegistrationRequestEntity
import com.example.domain.entities.RegistrationResponseEntity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MapperModule {

    @Provides
    @Singleton
    fun provideRegistrationRequestMapper(): BaseMapper<RegistrationRequestModel, RegistrationRequestEntity> =
        RegistrationRequestMapper()

    @Provides
    @Singleton
    fun provideRegistrationResponseMapper(): BaseMapper<RegistrationModel, RegistrationResponseEntity> =
        RegistrationResponseMapper()

    @Provides
    @Singleton
    fun provideLoginMapper(): BaseMapper<LoginResponse, LoginEntity> =
        LoginMapper()

    @Provides
    @Singleton
    fun providePhotoMapper(): BaseMapper<PhotoModel, PhotoEntity> =
        PhotoMapper()
}