package com.basakyardim.marsrovers_apod

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
    ,
) {

    object RoverItems: BottomNavItem(
        name = "Rovers",
        route = "rovers",
        icon =  Icons.Outlined.Home
    )

    object ApodItem: BottomNavItem(
        name = "Astronomy Picture of the Day",
        route = "apod",
        icon = Icons.Outlined.Star
    )
}
