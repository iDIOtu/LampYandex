package com.example.lab3.domain

import com.example.lab3.data.repository.LampRep
import javax.inject.Inject

class SetBrightnessLevelUseCaseImpl @Inject constructor( private val lampRepository: LampRep ): SetBrightnessLevelUseCase {

    override suspend fun invoke(level: Int): Boolean {
        return lampRepository.setBrightnessLevel(level)
    }
}