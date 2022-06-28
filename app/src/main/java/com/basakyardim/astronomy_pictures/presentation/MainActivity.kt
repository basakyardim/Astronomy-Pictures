package com.basakyardim.astronomy_pictures.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.basakyardim.astronomy_pictures.presentation.theme.MarsRoversApodTheme
import com.basakyardim.astronomy_pictures.presentation.theme.backgorund1
import com.basakyardim.astronomy_pictures.presentation.theme.background2
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarsRoversApodTheme() {

                Box(modifier = Modifier.fillMaxSize().background(
                    Brush.radialGradient(
                    colors = listOf(
                        backgorund1, background2
                    )
                ))) {
                    DestinationsNavHost(navGraph = NavGraphs.root)

                }


            }
        }
    }
}








