package com.basakyardim.marsrovers_apod.presentation

sealed class ScreenNavigation(val route: String) {
    object ApodListScreen: ScreenNavigation("apod_list_screen")
    object ApodDetailScreen: ScreenNavigation("apod_detail_screen")
}
