package com.basakyardim.astronomy_pictures.presentation.detail_screen

import com.basakyardim.astronomy_pictures.domain.model.AstronomyPictures

data class ApodDetailState(
    val isLoading: Boolean = false,
    val apod: AstronomyPictures? = null,
    val error: String = ""
)