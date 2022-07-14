package com.example.juniorgallery.di.module

import com.example.data.api.UserApi
import com.example.data.gateway.UserGatewayImpl
import com.example.data.models.RegistrationRequest
import com.example.data.models.RegistrationResponse
import com.example.domain.UserGateway
import com.example.domain.core.Mapper
import com.example.domain.entities.UserFullInfoEntity
import com.example.domain.entities.UserIdEntity
import com.example.juniorgallery.fragments.loginfragment.models.UiLogin
import com.example.juniorgallery.fragments.registrationfragmnet.models.UiRegistration
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class GatewayModule {

    @Provides
    @Singleton
    fun provideRegistrationUserGateway(
        userApi: UserApi,
        toDomainMapper: Mapper<RegistrationResponse, UserIdEntity>,
        toRegistrationRequestMapper: Mapper<UserFullInfoEntity, RegistrationRequest>,
    ): UserGateway<UiRegistration> = UserGatewayImpl(userApi, toDomainMapper, toRegistrationRequestMapper)

    fun provideLoginUserGateway(
        userApi: UserApi,
        toDomainMapper: Mapper<RegistrationResponse, UserIdEntity>,
        toRegistrationRequestMapper: Mapper<UserFullInfoEntity, RegistrationRequest>,
    ): UserGateway<UiLogin> = UserGatewayImpl(userApi, toDomainMapper, toRegistrationRequestMapper)
}