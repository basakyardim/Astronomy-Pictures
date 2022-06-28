package com.basakyardim.astronomy_pictures.domain.use_case

import com.basakyardim.astronomy_pictures.domain.model.AstronomyPictures
import com.basakyardim.astronomy_pictures.domain.repository.ApodRepository
import com.basakyardim.astronomy_pictures.util.Resource
import javax.inject.Inject

class ApodDetailUseCase @Inject constructor(
    private val repository: ApodRepository
) {
    suspend operator fun invoke(id: Int): Resource<AstronomyPictures?> {
        return repository.getApodDetail(id)
    }
}