package com.basakyardim.marsrovers_apod.domain.repository

import com.basakyardim.marsrovers_apod.data.remote.dto.ApodDto

interface ApodRepository {

    suspend fun getApods(start_date: String, api_key: String): List<ApodDto>

    suspend fun getApodbyDate(start_date: String, end_date: String, api_key: String): List<ApodDto>
}