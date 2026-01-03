package com.example.lab3.domain

interface GetColorsUseCase {
    suspend operator fun invoke(): List<String>
}