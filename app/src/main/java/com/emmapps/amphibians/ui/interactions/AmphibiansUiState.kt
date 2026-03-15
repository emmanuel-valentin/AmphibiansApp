package com.emmapps.amphibians.ui.interactions

import com.emmapps.amphibians.model.Amphibian

sealed interface AmphibiansUiState {
    data class Success(val amphibians: List<Amphibian>): AmphibiansUiState
    object Error: AmphibiansUiState
    object Loading: AmphibiansUiState
}