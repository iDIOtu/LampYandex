package com.example.lab3.di

import com.example.lab3.data.repository.LampRep
import com.example.lab3.data.repository.LampRepImpl
import com.example.lab3.domain.GetColorsUseCase
import com.example.lab3.domain.GetColorsUseCaseImpl
import com.example.lab3.domain.SetBrightnessLevelUseCase
import com.example.lab3.domain.SetBrightnessLevelUseCaseImpl
import com.example.lab3.domain.SetColorUseCase
import com.example.lab3.domain.SetColorUseCaseImpl
import com.example.lab3.domain.TurnOnUseCase
import com.example.lab3.domain.TurnOnUseCaseImpl
import com.example.lab3.domain.TurnOffUseCase
import com.example.lab3.domain.TurnOffUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindModule {
    @Binds
    fun bindLampRepository(repository: LampRepImpl): LampRep

    @Binds
    fun bindSetColorUseCase(useCase: SetColorUseCaseImpl): SetColorUseCase

    @Binds
    fun bindTurnOnUseCase(useCase: TurnOnUseCaseImpl): TurnOnUseCase

    @Binds
    fun bindTurnOffUseCase(useCase: TurnOffUseCaseImpl): TurnOffUseCase

    @Binds
    fun bindSetBrightnessLevelUseCase(useCase: SetBrightnessLevelUseCaseImpl): SetBrightnessLevelUseCase

    @Binds
    fun bindGetColorsUseCase(useCase: GetColorsUseCaseImpl): GetColorsUseCase
}