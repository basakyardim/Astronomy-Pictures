package com.basakyardim.marsrovers_apod.presentation.detail_screen

import com.basakyardim.marsrovers_apod.domain.model.Apod

data class ApodDetailState(
    val isLoading: Boolean = false,
    val apods: List<Apod> = emptyList(),
    val error: String = ""
)