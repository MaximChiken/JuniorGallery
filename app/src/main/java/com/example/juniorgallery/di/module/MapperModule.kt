package com.example.juniorgallery.di.module

import com.example.data.mappers.RegistrationResponseToDomainUserId
import com.example.data.mappers.UserDomainToRegistrationRequest
import com.example.data.models.RegistrationRequest
import com.example.data.models.RegistrationResponse
import com.example.domain.core.Mapper
import com.example.domain.entities.UserFullInfoEntity
import com.example.domain.entities.UserIdEntity
import com.example.juniorgallery.fragments.registrationfragmnet.mappers.UiRegistrationToUserDomain
import com.example.juniorgallery.fragments.registrationfragmnet.models.UiRegistration
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
    fun provideUserFullInfoDomainToRegistrationRequest(): Mapper <UserFullInfoEntity, RegistrationRequest> =
        UserDomainToRegistrationRequest()

    @Provides
    @Singleton
    fun provideUiRefistrationToUserDomain():Mapper<UiRegistration, UserFullInfoEntity> = UiRegistrationToUserDomain()

}