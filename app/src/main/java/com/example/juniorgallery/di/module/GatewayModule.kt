package com.example.juniorgallery.di.module

import com.example.data.api.PhotoApi
import com.example.data.api.UserApi
import com.example.data.base.BaseMapper
import com.example.data.gateway_impl.PhotoGatewayImpl
import com.example.data.gateway_impl.UserGatewayImpl
import com.example.data.models.LoginResponse
import com.example.data.models.PhotoModel
import com.example.data.models.RegistrationModel
import com.example.data.models.RegistrationRequestModel
import com.example.domain.entities.LoginEntity
import com.example.domain.entities.PhotoEntity
import com.example.domain.entities.RegistrationRequestEntity
import com.example.domain.entities.RegistrationResponseEntity
import com.example.domain.gateways.PhotoGateway
import com.example.domain.gateways.UserGateway
import dagger.Module
import dagger.Provides
import javax.inject.Named
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
    ): UserGateway = UserGatewayImpl(userApi, registrationRequestMapper, registrationResponseMapper, loginMapper)

    @Provides
    @Singleton
    fun providePhotoGateway(
        photoApi: PhotoApi,
        photoMapper: BaseMapper<PhotoModel, PhotoEntity>
    ): PhotoGateway = PhotoGatewayImpl(photoApi, photoMapper)
}