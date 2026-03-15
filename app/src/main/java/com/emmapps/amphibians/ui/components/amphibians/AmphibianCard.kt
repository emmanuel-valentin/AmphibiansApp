package com.emmapps.amphibians.ui.components.amphibians

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.emmapps.amphibians.R
import com.emmapps.amphibians.model.Amphibian
import com.emmapps.amphibians.ui.components.shared.NetworkImage

@Composable
fun AmphibianCard(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = modifier
    ) {
        Column {
            Text(
                text = amphibian.name,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(
                    horizontal = dimensionResource(R.dimen.padding_medium),
                    vertical = dimensionResource(R.dimen.padding_large)
                )
            )
            NetworkImage(
                url = amphibian.imgSrc,
                modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(1.5f),
                contentDescription = "Photo of a $amphibian.name"
            )
            Text(
                text = amphibian.description,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
            )
        }
    }
}

@Composable
@Preview
fun AmphibianCardPreview() {
    AmphibianCard(
        Amphibian(
            name = "Amphibian name",
            type = "Toad",
            description = "A simple description that shows details about a specific amphibian.",
            imgSrc = ""
        )
    )
}