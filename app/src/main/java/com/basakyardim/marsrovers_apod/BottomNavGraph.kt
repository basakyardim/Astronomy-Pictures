package com.basakyardim.marsrovers_apod

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.basakyardim.marsrovers_apod.presentation.apod_screen.ApodScreen
import com.basakyardim.marsrovers_apod.presentation.apod_screen.RoversScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.RoverItems.route
    ) {
        composable(route = BottomNavItem.RoverItems.route){
            RoversScreen()
        }
        composable(route = BottomNavItem.ApodItem.route){
            ApodScreen()
        }

    }
}