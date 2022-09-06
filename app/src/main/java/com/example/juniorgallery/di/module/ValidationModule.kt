package com.example.juniorgallery.di.module

import com.example.juniorgallery.validation.Validation
import com.example.juniorgallery.validation.ValidationImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class ValidationModule {

    @Binds
    @Singleton
    abstract fun provideValidation(validation: ValidationImpl): Validation
}