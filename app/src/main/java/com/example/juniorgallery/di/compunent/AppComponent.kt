package com.example.juniorgallery.di.compunent

import android.content.Context
import android.content.res.Resources
import com.example.juniorgallery.MyApp
import com.example.juniorgallery.di.module.ApiModule
import com.example.juniorgallery.di.module.AppModule
import com.example.juniorgallery.di.module.GatewayModule
import com.example.juniorgallery.di.module.RetrofitModule
import com.example.juniorgallery.loginfragment.LoginPresenter
import com.example.juniorgallery.registrationfragmnet.RegistrationPresenter
import com.example.juniorgallery.welcomefragment.WelcomePresenter
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class, ApiModule::class, GatewayModule::class])
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