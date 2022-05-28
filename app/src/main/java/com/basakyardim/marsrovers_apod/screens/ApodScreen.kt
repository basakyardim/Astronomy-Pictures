package com.basakyardim.marsrovers_apod.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ApodScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)

    ) {
        Text(text = "Astronomy Pic of the Day")

    }
}