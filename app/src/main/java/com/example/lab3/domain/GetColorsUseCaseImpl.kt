package com.example.lab3.domain

import com.example.lab3.data.repository.LampRep
import javax.inject.Inject

class GetColorsUseCaseImpl @Inject constructor( private val lampRepository: LampRep ): GetColorsUseCase {

    override suspend fun invoke(): List<String> {
        return lampRepository.getColors()
    }
}