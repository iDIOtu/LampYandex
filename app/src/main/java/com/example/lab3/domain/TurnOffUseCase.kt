package com.example.lab3.domain

interface TurnOffUseCase {
    suspend operator fun invoke(): Boolean
}