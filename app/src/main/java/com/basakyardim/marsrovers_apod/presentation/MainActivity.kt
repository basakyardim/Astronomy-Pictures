package com.basakyardim.marsrovers_apod.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.basakyardim.marsrovers_apod.presentation.apod_screen.ApodListScreen
import com.basakyardim.marsrovers_apod.presentation.detail_screen.ApodDetailScreen
import com.basakyardim.marsrovers_apod.presentation.theme.MarsRoversApodTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarsRoversApodTheme() {

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreenNavigation.ApodListScreen.route
                ) {
                    composable(
                        route = ScreenNavigation.ApodListScreen.route
                    ) {
                        ApodListScreen(navController)
                    }

                    composable(
                        route = ScreenNavigation.ApodDetailScreen.route + "/{start_date}"
                    ) {
                        ApodDetailScreen()
                    }

                }

            }
        }
    }
}








