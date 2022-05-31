package com.basakyardim.marsrovers_apod

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.basakyardim.marsrovers_apod.presentation.theme.itemColor

@Composable
fun BottomNavScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        BottomNavGraph(navController = navController)

    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomNavItem.RoverItems,
        BottomNavItem.ApodItem
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
            backgroundColor = itemColor
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )

        }

    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.name)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Item"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route)
        },
        selectedContentColor = Color.Black,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled)
    )
}