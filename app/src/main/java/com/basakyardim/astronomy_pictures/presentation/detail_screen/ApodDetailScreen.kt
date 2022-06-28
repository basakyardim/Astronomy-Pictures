package com.basakyardim.astronomy_pictures.presentation.detail_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.basakyardim.astronomy_pictures.presentation.detail_screen.components.ApodDetailItem
import com.ramcosta.composedestinations.annotation.Destination


@Composable
@Destination
fun ApodDetailScreen(
    id: Int,
    viewModel: ApodDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        else if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center),
                    color = Color.Black
            )
        }
        else {
            state.apod?.let { ApodDetailItem(apod = it) }

        }

    }

}