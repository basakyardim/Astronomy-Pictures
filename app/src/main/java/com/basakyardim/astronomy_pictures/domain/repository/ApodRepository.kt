package com.basakyardim.astronomy_pictures.domain.repository

import com.basakyardim.astronomy_pictures.domain.model.AstronomyPictures
import com.basakyardim.astronomy_pictures.util.Resource
import kotlinx.coroutines.flow.Flow

interface ApodRepository {

    fun getApods(start_date: String): Flow<Resource<List<AstronomyPictures>>>

    suspend fun getApodDetail(id: Int): Resource<AstronomyPictures?>
}