package com.example.juniorgallery.di.compunent

import android.content.Context
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.di.module.*
import com.example.juniorgallery.fragments.loginfragment.LoginPresenter
import com.example.juniorgallery.fragments.registrationfragmnet.RegistrationPresenter
import com.example.juniorgallery.fragments.welcomefragment.WelcomePresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class, ApiModule::class, GatewayModule::class, MapperModule::class])
interface AppComponent {

    fun inject(target: MyApp)

    fun provideWelcomePresenter(): WelcomePresenter

    fun provideLoginPresenter(): LoginPresenter

    fun provideRegistrationPresenter(): RegistrationPresenter

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: MyApp): Builder

        @BindsInstance
        fun context(context: Context): Builder
    }
}