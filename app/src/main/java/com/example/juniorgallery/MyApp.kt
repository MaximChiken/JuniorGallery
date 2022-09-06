package com.example.juniorgallery

import android.app.Application
import com.example.juniorgallery.di.compunent.AppComponent
import com.example.juniorgallery.di.compunent.DaggerAppComponent

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).context(applicationContext).build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}