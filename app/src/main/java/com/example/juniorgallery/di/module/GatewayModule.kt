package com.example.juniorgallery.di.module

import com.example.data.api.PhotoApi
import com.example.data.api.UserApi
import com.example.data.base.BaseMapper
import com.example.data.gateway_impl.PhotoGatewayImpl
import com.example.data.gateway_impl.UserGatewayImpl
import com.example.data.models.*
import com.example.domain.entities.*
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
        registrationRequestMapper: BaseMapper<RegistrationRequestModel, RegistrationRequestEntity>,
        registrationResponseMapper: BaseMapper<RegistrationModel, RegistrationResponseEntity>,
        loginMapper: BaseMapper<LoginResponse, LoginEntity>,
        passwordsMapper: BaseMapper<PasswordsModel, PasswordsEntity>,
    ): UserGateway =
        UserGatewayImpl(userApi, registrationRequestMapper, registrationResponseMapper, loginMapper, passwordsMapper)

    @Provides
    @Singleton
    fun providePhotoGateway(
        photoApi: PhotoApi,
        photoMapper: BaseMapper<PhotoModel, PhotoEntity>,
    ): PhotoGateway = PhotoGatewayImpl(photoApi, photoMapper)
}