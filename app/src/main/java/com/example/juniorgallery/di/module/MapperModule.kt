package com.example.juniorgallery.di.module

import com.example.data.mappers.RegistrationResponseToDomainUserId
import com.example.data.mappers.TokenToLoginResponse
import com.example.data.mappers.UserFullInfoDomainToRegistrationRequest
import com.example.data.models.LoginResponse
import com.example.data.models.RegistrationRequest
import com.example.data.models.RegistrationResponse
import com.example.domain.core.Mapper
import com.example.domain.entities.TokenEntity
import com.example.domain.entities.UserFullInfoEntity
import com.example.domain.entities.UserIdEntity
import com.example.domain.entities.UserInfoEntity
import com.example.juniorgallery.mappers.UiLoginToUserInfoDomain
import com.example.juniorgallery.mappers.UiRegistrationToUserFullInfoDomain
import com.example.juniorgallery.models.UiLogin
import com.example.juniorgallery.models.UiRegistration
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MapperModule {

    @Provides
    @Singleton
    fun provideRegistrationResponseToUserId(): Mapper<RegistrationResponse, UserIdEntity> =
        RegistrationResponseToDomainUserId()

    @Provides
    @Singleton
    fun provideUserFullInfoDomainToRegistrationRequest(): Mapper<UserFullInfoEntity, RegistrationRequest> =
        UserFullInfoDomainToRegistrationRequest()

    @Provides
    @Singleton
    fun provideUiRegistrationToUserFullInfoDomain(): Mapper<UiRegistration, UserFullInfoEntity> =
        UiRegistrationToUserFullInfoDomain()

    @Provides
    @Singleton
    fun provideUiLoginToUserInfoDomain(): Mapper<UiLogin, UserInfoEntity> =
        UiLoginToUserInfoDomain()

    @Provides
    @Singleton
    fun provideLoginResponseToTokenDomain(): Mapper<LoginResponse, TokenEntity> =
        TokenToLoginResponse()

}