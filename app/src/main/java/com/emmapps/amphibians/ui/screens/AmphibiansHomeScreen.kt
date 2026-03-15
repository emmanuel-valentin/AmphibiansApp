package com.emmapps.amphibians.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.emmapps.amphibians.R
import com.emmapps.amphibians.model.Amphibian
import com.emmapps.amphibians.ui.components.amphibians.AmphibiansErrorView
import com.emmapps.amphibians.ui.components.amphibians.AmphibiansGrid
import com.emmapps.amphibians.ui.components.amphibians.AmphibiansLoadingView
import com.emmapps.amphibians.ui.interactions.AmphibiansUiState

@Composable
fun AmphibiansHomeScreen(
    amphibiansUiState: AmphibiansUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (amphibiansUiState) {
        is AmphibiansUiState.Success -> {
            AmphibiansGrid(
                amphibians = amphibiansUiState.amphibians,
                modifier = modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
        AmphibiansUiState.Error -> {
            AmphibiansErrorView(
                retryAction = retryAction,
                modifier = modifier.fillMaxSize()
            )
        }
        AmphibiansUiState.Loading -> {
            AmphibiansLoadingView(modifier = Modifier.fillMaxSize())
        }
    }
}
