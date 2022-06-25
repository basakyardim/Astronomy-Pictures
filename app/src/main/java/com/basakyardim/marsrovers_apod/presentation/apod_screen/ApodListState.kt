package com.basakyardim.marsrovers_apod.presentation.apod_screen

import com.basakyardim.marsrovers_apod.domain.model.Apod

data class ApodListState(
    val isLoading: Boolean = false,
    val apods: List<Apod> = emptyList(),
    val error: String = ""
)
