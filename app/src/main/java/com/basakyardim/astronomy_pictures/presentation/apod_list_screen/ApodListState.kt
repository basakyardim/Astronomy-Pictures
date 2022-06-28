package com.basakyardim.astronomy_pictures.presentation.apod_list_screen

import com.basakyardim.astronomy_pictures.domain.model.AstronomyPictures

data class ApodListState(
    val isLoading: Boolean = false,
    val apods: List<AstronomyPictures> = emptyList(),
    val error: String = ""
)
