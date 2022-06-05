package com.basakyardim.marsrovers_apod.data.repository

import com.basakyardim.marsrovers_apod.data.remote.ApodApi
import com.basakyardim.marsrovers_apod.data.remote.dto.ApodDto
import com.basakyardim.marsrovers_apod.domain.repository.ApodRepository
import javax.inject.Inject

class ApodRepositoryImpl @Inject constructor(
    private val api: ApodApi
) : ApodRepository {
    override suspend fun getApods(start_date: String, api_key: String): List<ApodDto> {
        return api.getApods(start_date, api_key)
    }

    override suspend fun getApodbyDate(
        start_date: String,
        end_date: String,
        api_key: String
    ): List<ApodDto> {
        return api.getApodbyDate(start_date, end_date, api_key)
    }


}