package com.basakyardim.marsrovers_apod.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.basakyardim.marsrovers_apod.BottomNavScreen
import com.basakyardim.marsrovers_apod.presentation.theme.MarsRoversApodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarsRoversApodTheme() {
                BottomNavScreen()

            }
        }
    }
}








