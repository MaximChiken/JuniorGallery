package com.example.juniorgallery.di.module

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.data.interceptors.HeaderInterceptor
import com.example.data.interceptors.RefreshTokenInterceptor
import com.example.data.managers.tokenmanager.TokenManager
import com.example.domain.gateways.AuthGateway
import dagger.Lazy
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        chuckerInterceptor: ChuckerInterceptor,
        tokenManager: TokenManager,
        authGateway: Lazy<AuthGateway>,
    ) = OkHttpClient.Builder()
        .authenticator(RefreshTokenInterceptor(authGateway, tokenManager))
        .addInterceptor(chuckerInterceptor)
        .addInterceptor(HeaderInterceptor(tokenManager))
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://gallery.prod1.webant.ru")
        .client((okHttpClient))
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideChuker(context: Context) = ChuckerInterceptor.Builder(context).build()
}