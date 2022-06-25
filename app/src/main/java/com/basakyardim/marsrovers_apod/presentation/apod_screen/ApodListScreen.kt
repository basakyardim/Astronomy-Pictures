package com.basakyardim.marsrovers_apod.presentation.apod_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.basakyardim.marsrovers_apod.presentation.ScreenNavigation
import com.basakyardim.marsrovers_apod.presentation.apod_screen.components.ApodListItem
import com.basakyardim.marsrovers_apod.presentation.theme.itemColor

@Composable
fun ApodListScreen(
    navController: NavController,
    viewModel: ApodListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.apods) { apod ->
                ApodListItem(
                    apod = apod,
                    onItemClick = {
                        navController.navigate(ScreenNavigation.ApodDetailScreen.route + "/${apod.date}")
                    }
                )

            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = itemColor
            )
        }

    }
}