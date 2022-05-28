package com.basakyardim.marsrovers_apod

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.basakyardim.marsrovers_apod.screens.ApodScreen
import com.basakyardim.marsrovers_apod.screens.RoversScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Rovers.route
    ) {
        composable(route = BottomNavItem.Rovers.route){
            RoversScreen()
        }
        composable(route = BottomNavItem.Apod.route){
            ApodScreen()
        }

    }
}