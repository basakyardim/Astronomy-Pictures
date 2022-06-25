package com.basakyardim.marsrovers_apod.presentation.apod_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.basakyardim.marsrovers_apod.common.DEFAULT_IMAGE
import com.basakyardim.marsrovers_apod.common.LoadPicture
import com.basakyardim.marsrovers_apod.domain.model.Apod
import com.basakyardim.marsrovers_apod.presentation.theme.itemColor

@Composable
fun ApodListItem(
    apod: Apod,
    onItemClick: (Apod) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(apod) }
            .padding(30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "${apod.title}",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.weight(1.2f),
            color = itemColor,
            overflow = TextOverflow.Ellipsis,
            maxLines = 3
        )

        apod.url?.let { url ->
            val image = LoadPicture(url = url, defaultImage = DEFAULT_IMAGE).value
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    contentDescription = "APOD",
                    modifier = Modifier
                        .fillMaxSize(0.2f),
                    contentScale = ContentScale.Fit
                )

            }


        }

    }
}