package com.example.juniorgallery.di.module

import com.example.data.api.UserApi
import com.example.data.base.BaseMapper
import com.example.data.gateway_impl.UserGatewayImpl
import com.example.data.models.LoginResponse
import com.example.data.models.RegistrationModel
import com.example.data.models.RegistrationRequestModel
import com.example.domain.entities.LoginEntity
import com.example.domain.entities.RegistrationRequestEntity
import com.example.domain.entities.RegistrationResponseEntity
import com.example.domain.gateways.UserGateway
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class GatewayModule {

    @Provides
    @Singleton
    fun provideGateway(
        userApi: UserApi,
        registrationRequestMapper: BaseMapper<RegistrationRequestModel, RegistrationRequestEntity>,
        registrationResponseMapper: BaseMapper<RegistrationModel, RegistrationResponseEntity>,
        loginMapper: BaseMapper<LoginResponse, LoginEntity>,
    ): UserGateway = UserGatewayImpl(userApi, registrationRequestMapper, registrationResponseMapper, loginMapper)

}