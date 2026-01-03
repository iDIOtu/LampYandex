package com.example.lab3.di

import com.example.lab3.data.api.LampService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideLampApi(): LampService {
        return Retrofit.Builder()
            .baseUrl("http://195.133.53.179:1337/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LampService::class.java)
    }
}