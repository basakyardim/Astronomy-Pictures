package com.basakyardim.marsrovers_apod.domain.use_case.get_apod

import com.basakyardim.marsrovers_apod.common.Resource
import com.basakyardim.marsrovers_apod.data.remote.dto.toApod
import com.basakyardim.marsrovers_apod.domain.model.Apod
import com.basakyardim.marsrovers_apod.domain.repository.ApodRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetApodUseCase @Inject constructor(
    private val repository: ApodRepository
) {
    operator fun invoke(
        start_date: String,
        end_date: String,
        api_key: String
    ): Flow<Resource<List<Apod>>> = flow {
        try {
            emit(Resource.Loading<List<Apod>>())


        } catch (e: HttpException) {
            emit(Resource.Error<List<Apod>>(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException) {
            emit(Resource.Error<List<Apod>>("Couldn't reach the server. Check your internet connection."))

        }
    }
}