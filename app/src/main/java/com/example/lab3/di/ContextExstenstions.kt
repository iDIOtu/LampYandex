package com.example.lab3.di

import android.content.Context
import com.example.lab3.MyApplication

val Context.appComponent: AppComponent
    get() = when(this){
        is MyApplication -> this.appComponent
        else -> applicationContext.appComponent
    }