package com.example.lab3.domain

import com.example.lab3.data.repository.LampRep
import javax.inject.Inject

class TurnOffUseCaseImpl @Inject constructor( private val lampRepository: LampRep ): TurnOffUseCase {

    override suspend fun invoke(): Boolean {
        return lampRepository.turnOff()
    }
}