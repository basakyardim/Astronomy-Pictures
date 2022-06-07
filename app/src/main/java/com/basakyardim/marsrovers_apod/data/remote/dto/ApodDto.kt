package com.basakyardim.marsrovers_apod.data.remote.dto

import com.basakyardim.marsrovers_apod.domain.model.Apod

data class ApodDto(
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String
)

fun ApodDto.toApod(): Apod {
    return Apod(
        copyright = copyright,
        date = date,
        explanation = explanation,
        hdurl = hdurl,
        media_type = media_type,
        title = title,
        url = url
    )

}