@file:OptIn(ExperimentalMaterial3Api::class)

package com.emmapps.amphibians.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.emmapps.amphibians.ui.components.shared.AmphibiansAppBar
import com.emmapps.amphibians.ui.screens.AmphibiansHomeScreen
import com.emmapps.amphibians.ui.viewmodels.AmphibiansViewModel

@Composable
fun AmphibiansApp(
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = {
            AmphibiansAppBar(scrollBehavior = scrollBehavior)
        },
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize()
    ) { innerPadding ->
        val amphibiansViewModel: AmphibiansViewModel = viewModel(
            factory = AmphibiansViewModel.Factory
        )
        val amphibiansUiState = amphibiansViewModel.amphibiansUiState.collectAsStateWithLifecycle()
        AmphibiansHomeScreen(
            amphibiansUiState = amphibiansUiState.value,
            retryAction = amphibiansViewModel::getAmphibians,
            modifier = Modifier.padding(innerPadding)
        )
    }
}