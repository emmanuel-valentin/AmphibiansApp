@file:OptIn(ExperimentalMaterial3Api::class)

package com.emmapps.amphibians.ui.components.shared

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.emmapps.amphibians.R

@Composable
fun AmphibiansAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall
            )
        },
        scrollBehavior = scrollBehavior,
        modifier = modifier,
    )
}