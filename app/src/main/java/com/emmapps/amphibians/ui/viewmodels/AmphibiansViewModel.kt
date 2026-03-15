package com.emmapps.amphibians.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.emmapps.amphibians.AmphibiansApplication
import com.emmapps.amphibians.data.amphibians.AmphibiansRepository
import com.emmapps.amphibians.ui.interactions.AmphibiansUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okio.IOException

class AmphibiansViewModel(
    private val amphibiansRepository: AmphibiansRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<AmphibiansUiState>(AmphibiansUiState.Loading)
    val amphibiansUiState = _uiState.asStateFlow()

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            try {
                val amphibians = amphibiansRepository.getAmphibians()
                _uiState.value = AmphibiansUiState.Success(amphibians)
            } catch (e: IOException) {
                _uiState.value = AmphibiansUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibiansViewModel(amphibiansRepository)
            }
        }
    }
}