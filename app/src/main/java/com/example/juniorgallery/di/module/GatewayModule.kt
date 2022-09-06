package com.example.juniorgallery.di.module

import com.example.data.api.AuthApi
import com.example.data.api.MediaObjectApi
import com.example.data.api.PhotoApi
import com.example.data.api.UserApi
import com.example.data.base.BaseMapper
import com.example.data.gateway_impl.AuthGatewayImpl
import com.example.data.gateway_impl.MediaObjectGatewayImpl
import com.example.data.gateway_impl.PhotoGatewayImpl
import com.example.data.gateway_impl.UserGatewayImpl
import com.example.data.models.*
import com.example.domain.entities.*
import com.example.domain.gateways.AuthGateway
import com.example.domain.gateways.MediaObjectGateway
import com.example.domain.gateways.PhotoGateway
import com.example.domain.gateways.UserGateway
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class GatewayModule {

    @Provides
    @Singleton
    fun provideUserGateway(
        userApi: UserApi,
        userMapper: BaseMapper<UserModel, UserEntity>,
        passwordsMapper: BaseMapper<PasswordsModel, PasswordsEntity>,
    ): UserGateway =
        UserGatewayImpl(userApi, userMapper, passwordsMapper)

    @Provides
    @Singleton
    fun provideAuthGateway(
        authApi: AuthApi,
        registrationMapper: BaseMapper<RegistrationModel, RegistrationEntity>,
        tokenMapper: BaseMapper<TokenResponse, TokenEntity>,
    ): AuthGateway =
        AuthGatewayImpl(authApi, registrationMapper, tokenMapper)

    @Provides
    @Singleton
    fun providePhotoGateway(
        photoApi: PhotoApi,
        photoMapper: BaseMapper<PhotoListModel, PhotoListEntity>,
        newPhotoMapper: BaseMapper<NewPhotoModel, NewPhotoEntity>,
        photoInfoMapper: BaseMapper<PhotoInfoModel, PhotoInfoEntity>,
    ): PhotoGateway = PhotoGatewayImpl(photoApi, photoMapper, newPhotoMapper, photoInfoMapper)

    @Provides
    @Singleton
    fun provideMediaObjectGateway(
        mediaObjectApi: MediaObjectApi,
        mediaObjectMapper: BaseMapper<MediaObjectModel, MediaObjectEntity>,
    ): MediaObjectGateway = MediaObjectGatewayImpl(mediaObjectApi, mediaObjectMapper)
}