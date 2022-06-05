package com.basakyardim.marsrovers_apod.presentation.apod_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.basakyardim.marsrovers_apod.domain.model.Apod

@Composable
fun ApodListItem(
    apod: Apod,
    onItemClick: (Apod) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onItemClick(apod) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${apod.title}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )

    }

}