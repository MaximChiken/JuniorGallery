package com.example.juniorgallery.di.module

import com.example.data.base.BaseMapper
import com.example.data.mappers.*
import com.example.data.models.*
import com.example.domain.entities.*
import com.example.juniorgallery.base.BaseUiMapper
import com.example.juniorgallery.screenviewmodels.PhotoInfoScreenModel
import com.example.juniorgallery.screenviewmodels.PhotoListScreenModel
import com.example.juniorgallery.screenviewmodels.uimappers.UiPhotoInfoMapper
import com.example.juniorgallery.screenviewmodels.uimappers.UiPhotoListMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MapperModule {

    @Provides
    @Singleton
    fun provideRegistrationMapper(): BaseMapper<RegistrationModel, RegistrationEntity> = RegistrationMapper()

    @Provides
    @Singleton
    fun provideUserMapper(): BaseMapper<UserModel, UserEntity> = UserMapper()

    @Provides
    @Singleton
    fun provideTokenMapper(): BaseMapper<TokenResponse, TokenEntity> = TokenMapper()

    @Provides
    @Singleton
    fun providePhotoMapper(
        photoInfoMapper: BaseMapper<PhotoInfoModel, PhotoInfoEntity>,
    ): BaseMapper<PhotoListModel, PhotoListEntity> = PhotoListMapper(photoInfoMapper)

    @Provides
    @Singleton
    fun providePasswordsMapper(): BaseMapper<PasswordsModel, PasswordsEntity> = PasswordsMapper()

    @Provides
    @Singleton
    fun provideMediaObjectMapper(): BaseMapper<MediaObjectModel, MediaObjectEntity> = MediaObjectMapper()

    @Provides
    @Singleton
    fun provideNewPhotoMapper(): BaseMapper<NewPhotoModel, NewPhotoEntity> = NewPhotoMapper()

    @Provides
    @Singleton
    fun providePhotoInfoMapper(): BaseMapper<PhotoInfoModel, PhotoInfoEntity> = PhotoInfoMapper()

    @Provides
    @Singleton
    fun provideUiPhotoInfoMapper(): BaseUiMapper<PhotoInfoScreenModel, PhotoInfoEntity> = UiPhotoInfoMapper()

    @Provides
    @Singleton
    fun provideUiPhotoListMapper(
        uiPhotoInfoMapper: BaseUiMapper<PhotoInfoScreenModel, PhotoInfoEntity>,
    ): BaseUiMapper<PhotoListScreenModel, PhotoListEntity> = UiPhotoListMapper(uiPhotoInfoMapper)
}