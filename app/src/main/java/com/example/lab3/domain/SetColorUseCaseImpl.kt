package com.example.lab3.domain

import com.example.lab3.data.repository.LampRep
import javax.inject.Inject

class SetColorUseCaseImpl @Inject constructor( private val lampRepository: LampRep ): SetColorUseCase {

    override suspend fun invoke(color: String): Boolean {
        return lampRepository.setColor(color)
    }
}