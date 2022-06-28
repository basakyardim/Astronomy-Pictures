package com.basakyardim.astronomy_pictures.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.basakyardim.astronomy_pictures.domain.model.AstronomyPictures

@Entity(tableName = "pictures")
data class PicturesEntity(
    val copyright: String?,
    val date: String?,
    val explanation: String?,
    val hdurl: String?,
    val media_type: String?,
    val service_version: String?,
    val title: String?,
    val url: String?,
    @PrimaryKey val id: Int? = null
) {
    fun toAstronomyPictures(): AstronomyPictures {
        return AstronomyPictures(
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


