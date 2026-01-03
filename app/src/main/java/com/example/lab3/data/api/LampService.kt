package com.example.lab3.data.api

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LampService
{
    @POST("color/")
    suspend fun setColor(@Query("color") colorName: String): Boolean

    @POST("state/on")
    suspend fun turnOn(): Boolean

    @POST("state/off")
    suspend fun turnOff(): Boolean

    @POST("brightness/")
    suspend fun setBrightnessLevel(@Query("level") brightnessLevel: Int): Boolean

    @GET("color/names_only")
    suspend fun getColors(): List<String>
}