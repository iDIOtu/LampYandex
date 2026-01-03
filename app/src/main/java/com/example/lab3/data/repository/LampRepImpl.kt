package com.example.lab3.data.repository

import javax.inject.Inject
import com.example.lab3.data.api.LampService

class LampRepImpl @Inject constructor( private val service: LampService ) : LampRep {

    override suspend fun setColor(colorName: String): Boolean {
        return service.setColor(colorName)
    }

    override suspend fun turnOn(): Boolean {
        return service.turnOn()
    }

    override suspend fun turnOff(): Boolean {
        return service.turnOff()
    }

    override suspend fun setBrightnessLevel(brightnessLevel: Int): Boolean {
        return service.setBrightnessLevel(brightnessLevel)
    }

    override suspend fun getColors(): List<String> {
        return service.getColors()
    }
}