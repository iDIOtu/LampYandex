package com.example.lab3.domain

import com.example.lab3.data.repository.LampRep
import javax.inject.Inject

class TurnOnUseCaseImpl @Inject constructor( private val lampRepository: LampRep ): TurnOnUseCase {

    override suspend fun invoke(): Boolean {
        return lampRepository.turnOn()
    }
}