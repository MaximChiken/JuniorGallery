package com.example.juniorgallery.di.module

import com.example.data.base.BaseMapper
import com.example.data.mappers.*
import com.example.data.models.*
import com.example.domain.entities.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MapperModule {

    @Provides
    @Singleton
    fun provideUserMapper(): BaseMapper<RegistrationModel, RegistrationEntity> =
        RegistrationMapper()

    @Provides
    @Singleton
    fun provideRegistrationMapper(): BaseMapper<UserModel, UserEntity> =
        UserMapper()

    @Provides
    @Singleton
    fun provideTokenMapper(): BaseMapper<TokenResponse, TokenEntity> =
        TokenMapper()

    @Provides
    @Singleton
    fun providePhotoMapper(): BaseMapper<PhotoListModel, PhotoListEntity> =
        PhotoMapper()

    @Provides
    @Singleton
    fun providePasswordsMapper(): BaseMapper<PasswordsModel, PasswordsEntity> =
        PasswordsMapper()

    @Provides
    @Singleton
    fun provideMediaObjectMapper(): BaseMapper<MediaObjectModel, MediaObjectEntity> =
        MediaObjectMapper()
}