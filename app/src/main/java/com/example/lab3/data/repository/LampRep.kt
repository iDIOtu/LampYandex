package com.example.lab3.data.repository

interface LampRep {
    suspend fun setColor(colorName: String): Boolean
    suspend fun turnOn(): Boolean
    suspend fun turnOff(): Boolean
    suspend fun setBrightnessLevel(brightnessLevel: Int): Boolean
    suspend fun getColors():List<String>
}