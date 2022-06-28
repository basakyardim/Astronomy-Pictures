package com.basakyardim.astronomy_pictures.presentation.detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basakyardim.astronomy_pictures.domain.use_case.ApodDetailUseCase
import com.basakyardim.astronomy_pictures.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ApodDetailViewModel @Inject constructor(
    private val apodDetailUseCase: ApodDetailUseCase,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val _state = mutableStateOf(ApodDetailState())
    val state: State<ApodDetailState> = _state

    init {
        viewModelScope.launch {
            val id = savedStateHandle.get<Int>("id") ?: return@launch
            getApodDetail(id)

        }
    }

    private suspend fun getApodDetail(id: Int) {
        val info = apodDetailUseCase(id)
            when (info) {
                is Resource.Success<*> -> {
                    _state.value = ApodDetailState(apod = info.data)
                }
                is Resource.Error<*> -> {
                    _state.value = ApodDetailState(
                        error = info.message ?: "An unexpected error occurred."
                    )
                }
                is Resource.Loading<*> -> {
                    _state.value = ApodDetailState(isLoading = true)
                }
            }

    }


}


