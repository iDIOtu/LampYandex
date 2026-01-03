package com.example.lab3.presenter.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab3.domain.SetColorUseCase
import com.example.lab3.UiState
import com.example.lab3.domain.GetColorsUseCase
import com.example.lab3.domain.SetBrightnessLevelUseCase
import com.example.lab3.domain.TurnOffUseCase
import com.example.lab3.domain.TurnOnUseCase
import com.example.lab3.toUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragmentViewModel  @Inject constructor(
    private val setColorUseCase: SetColorUseCase,
    private val turnOnUseCase: TurnOnUseCase,
    private val turnOffUseCase: TurnOffUseCase,
    private val setBrightnessLevelUseCase: SetBrightnessLevelUseCase,
    private val getColorsUseCase: GetColorsUseCase
    ) : ViewModel() {

    private val _colors = MutableLiveData<UiState<List<String>>>()
    val colors: LiveData<UiState<List<String>>> = _colors

    fun setColor(color: String) {
        viewModelScope.launch { setColorUseCase(color) }
    }

    fun turnOn() {
        viewModelScope.launch { turnOnUseCase() }
    }

    fun turnOff() {
        viewModelScope.launch { turnOffUseCase() }
    }

    fun setBrightness(value: Int) {
        viewModelScope.launch { setBrightnessLevelUseCase(value) }
    }

    fun getColors() {
        viewModelScope.launch {
            _colors.value = UiState.Loading
            _colors.value = runCatching { getColorsUseCase() }.toUiState()
        }
    }

}