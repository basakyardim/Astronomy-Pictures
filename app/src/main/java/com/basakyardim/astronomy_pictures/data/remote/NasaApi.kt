package com.basakyardim.astronomy_pictures.data.remote

import com.basakyardim.astronomy_pictures.BuildConfig
import com.basakyardim.astronomy_pictures.data.remote.NasaApi.Companion.API_KEY
import com.basakyardim.astronomy_pictures.data.remote.dto.AstronomyPicturesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {
    @GET("/planetary/apod")
    suspend fun fetchPictures(
        @Query("start_date") start_date: String,
        @Query("api_key") api_key: String = API_KEY
    ): List<AstronomyPicturesDto>

    companion object {
        const val API_KEY = BuildConfig.API_KEY
        const val BASE_URL = "https://api.nasa.gov/"


    }

}