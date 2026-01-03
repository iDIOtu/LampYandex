package com.example.lab3

import android.app.Application
import com.example.lab3.di.AppComponent
import com.example.lab3.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}