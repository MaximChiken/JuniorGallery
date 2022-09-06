package com.example.juniorgallery.di.module

import android.content.Context
import android.content.SharedPreferences
import com.example.data.shared_preferences.TokenPreferences
import com.example.data.shared_preferences.TokenPreferencesImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class SharedPreferencesModule {

    @Provides
    @Singleton
    @Named("tokens_shared_preferences")
    fun provideUserPreferences(context: Context): SharedPreferences =
        context.getSharedPreferences("tokens_shared_preferences", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideUserPreferencesGateway(@Named("tokens_shared_preferences") sharedPreferences: SharedPreferences):
            TokenPreferences = TokenPreferencesImpl(sharedPreferences)
}