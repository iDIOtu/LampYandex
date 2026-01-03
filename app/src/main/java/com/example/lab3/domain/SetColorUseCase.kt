package com.example.lab3.domain

interface SetColorUseCase {
    suspend operator fun invoke(color: String): Boolean
}