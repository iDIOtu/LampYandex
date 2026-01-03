package com.example.lab3.domain

interface TurnOnUseCase {
    suspend operator fun invoke(): Boolean
}