package com.example.lab3.domain

interface SetBrightnessLevelUseCase {
    suspend operator fun invoke(level: Int): Boolean
}