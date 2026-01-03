package com.example.lab3.presenter.sample

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lab3.R
import com.example.lab3.UiState
import com.example.lab3.databinding.FragmentSampleBinding
import com.example.lab3.di.ViewModelFactory
import com.example.lab3.di.appComponent
import javax.inject.Inject

class SampleFragment : Fragment(R.layout.fragment_sample) {

    private val binding: FragmentSampleBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainFragmentViewModel by viewModels() { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getColors()

        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        binding.spinnerColors.adapter = adapter


        viewModel.colors.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UiState.Success -> {
                    adapter.clear()
                    adapter.addAll(state.value)
                }
                is UiState.Failure -> {
                    adapter.clear()
                    adapter.add("Нет цветов")
                }
                else -> {}
            }
        }

        updateUiState(binding.switchLamp.isChecked)

        binding.spinnerColors.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, v: View?, position: Int, id: Long) {
                val selectedText = adapter.getItem(position) ?: ""
                if (selectedText.isNotEmpty() && selectedText != "Нет цветов" && binding.switchLamp.isChecked) {
                    viewModel.setColor(selectedText)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.switchLamp.setOnCheckedChangeListener { _, isChecked ->
            updateUiState(isChecked)
            if (isChecked) viewModel.turnOn() else viewModel.turnOff()
        }

        binding.seekBarBrightness.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                viewModel.setBrightness(progress)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
    }

    fun updateUiState(isLampOn: Boolean) {
        binding.seekBarBrightness.isEnabled = isLampOn
        binding.spinnerColors.isEnabled = isLampOn

        val alpha = if (isLampOn) 1.0f else 0.5f
        binding.seekBarBrightness.alpha = alpha
        binding.spinnerColors.alpha = alpha
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }
}