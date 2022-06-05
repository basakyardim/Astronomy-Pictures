package com.basakyardim.marsrovers_apod.data.remote

import com.basakyardim.marsrovers_apod.data.remote.dto.ApodDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodApi {
    @GET("planetary/apod")
    suspend fun getApods(@Query("start_date") start_date: String, @Query("api_key") api_key: String): List<ApodDto>

    @GET("planetary/apod")
    suspend fun getApodbyDate(@Query("start_date") start_date: String,
                              @Query("end_date") end_date: String,
                              @Query("api_key") api_key: String): List<ApodDto>

}