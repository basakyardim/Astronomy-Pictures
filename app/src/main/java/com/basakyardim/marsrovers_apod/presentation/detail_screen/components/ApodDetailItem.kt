package com.basakyardim.marsrovers_apod.presentation.detail_screen.components

import android.graphics.Paint
import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.basakyardim.marsrovers_apod.presentation.theme.itemColor

@Composable
fun ApodDetailItem(
    title: String,
    explanation: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = title,
            color = itemColor,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2
        )
        
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = explanation,
            color = itemColor,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1
        )

    }

}