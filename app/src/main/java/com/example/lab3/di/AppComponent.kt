package com.example.lab3.di

import com.example.lab3.presenter.sample.SampleFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        NetworkModule::class,
        AppBindModule::class,
    ]
)
interface AppComponent {
    fun inject(fragment: SampleFragment)
}