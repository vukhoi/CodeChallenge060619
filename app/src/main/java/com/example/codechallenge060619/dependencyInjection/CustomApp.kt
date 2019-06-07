package com.example.codechallenge060619.dependencyInjection

import android.app.Application

class CustomApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()

    }
}
