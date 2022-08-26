package com.example.juniorgallery.di.module

import com.example.juniorgallery.validation.Validation
import com.example.juniorgallery.validation.ValidationImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ValidationModule {

    @Provides
    @Singleton
    fun provideValidation(): Validation = ValidationImpl()
}