package com.emmapps.amphibians.ui.components.shared

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.emmapps.amphibians.R

@Composable
fun NetworkImage(
    url: String,
    modifier: Modifier = Modifier,
    contentDescription: String?,
) {
    Card(
        shape = RoundedCornerShape(0.dp),
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(url)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            placeholder = painterResource(R.drawable.loading_img),
            error = painterResource(R.drawable.ic_broken_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}