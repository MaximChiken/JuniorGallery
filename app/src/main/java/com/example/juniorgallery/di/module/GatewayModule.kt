package com.example.juniorgallery.di.module

import com.example.data.api.UserApi
import com.example.data.gateway.UserGatewayImpl
import com.example.domain.UserGateway
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class GatewayModule {

    @Provides
    @Singleton
    fun provideUserGateway(userApi: UserApi): UserGateway = UserGatewayImpl(userApi)
}