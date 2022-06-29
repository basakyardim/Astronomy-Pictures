package com.basakyardim.astronomy_pictures.data.remote.dto

import com.basakyardim.astronomy_pictures.data.local.PicturesEntity

data class AstronomyPicturesDto(
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String
) {

    fun toPicturesEntity(): PicturesEntity {
        return PicturesEntity(
            copyright = copyright,
            date = date,
            explanation = explanation,
            hdurl = hdurl,
            media_type = media_type,
            service_version = service_version,
            title = title,
            url = url
        )

    }
}


