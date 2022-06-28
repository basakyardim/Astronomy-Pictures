package com.basakyardim.astronomy_pictures.domain.use_case

import com.basakyardim.astronomy_pictures.domain.model.AstronomyPictures
import com.basakyardim.astronomy_pictures.domain.repository.ApodRepository
import com.basakyardim.astronomy_pictures.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ApodListUseCase @Inject constructor(
    private val repository: ApodRepository
) {
    operator fun invoke(start_date: String): Flow<Resource<List<AstronomyPictures>>> {

        return repository.getApods(start_date = start_date)
    }
}