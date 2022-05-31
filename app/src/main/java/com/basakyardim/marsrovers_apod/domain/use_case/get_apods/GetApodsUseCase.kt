package com.basakyardim.marsrovers_apod.domain.use_case.get_apods

import com.basakyardim.marsrovers_apod.domain.repository.ApodRepository
import javax.inject.Inject

class GetApodsUseCase @Inject constructor(
    private val repository: ApodRepository
) {
}