package com.emmapps.amphibians.ui.components.amphibians

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.emmapps.amphibians.R
import com.emmapps.amphibians.model.Amphibian

@Composable
fun AmphibiansGrid(
    amphibians: List<Amphibian>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement
            .spacedBy(dimensionResource(R.dimen.padding_large)),
        modifier = modifier,
    ) {
        items(amphibians, key = { amphibian -> amphibian.name.lowercase() }) { amphibian ->
            AmphibianCard(amphibian = amphibian)
        }
    }
}

@Composable
@Preview
fun AmphibiansGridPreview() {
    val amphibians = List(10) {
        Amphibian(
            name = "Test name $it",
            type = "Type",
            description = "A detailed description about Test name $it",
            imgSrc = ""
        )
    }
    AmphibiansGrid(amphibians = amphibians)
}