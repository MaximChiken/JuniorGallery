package com.example.juniorgallery.di.module

import com.example.data.api.UserApi
import com.example.data.gateway.UserGatewayImpl
import com.example.data.models.LoginResponse
import com.example.data.models.RegistrationRequest
import com.example.data.models.RegistrationResponse
import com.example.domain.UserGateway
import com.example.domain.core.Mapper
import com.example.domain.entities.TokenEntity
import com.example.domain.entities.UserFullInfoEntity
import com.example.domain.entities.UserIdEntity
import com.example.juniorgallery.models.UiLogin
import com.example.juniorgallery.models.UiRegistration
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class GatewayModule {

    @Provides
    @Singleton
    fun provideGateway(
        userApi: UserApi,
        toRegistrationRequestMapper: Mapper<UserFullInfoEntity, RegistrationRequest>,
        toDomainMapper: Mapper<RegistrationResponse, UserIdEntity>,
        toTokenDomainMapper: Mapper<LoginResponse, TokenEntity>,
    ): UserGateway = UserGatewayImpl(userApi,  toRegistrationRequestMapper, toDomainMapper, toTokenDomainMapper)

}