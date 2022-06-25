package com.basakyardim.marsrovers_apod.presentation.detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basakyardim.marsrovers_apod.common.Constants
import com.basakyardim.marsrovers_apod.common.Resource
import com.basakyardim.marsrovers_apod.domain.use_case.get_apod.GetApodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ApodDetailViewModel @Inject constructor(
    private val getApodUseCase: GetApodUseCase,
    savedStateHandle: SavedStateHandle

): ViewModel() {
    private val _state =  mutableStateOf(ApodDetailState())
    val state: State<ApodDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_DATE)?.let { param_date ->
            getApod(start_date = param_date, end_date = param_date, api_key = Constants.API_KEY )
        }
    }

    private fun getApod(start_date: String, end_date: String, api_key: String) {
        getApodUseCase(start_date = start_date, end_date = end_date, api_key = api_key).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ApodDetailState(apods = result.data ?: emptyList())

                }
                is Resource.Error -> {
                    _state.value = ApodDetailState(
                        error = result.message ?: "An unexpected error occurred."
                    )

                }
                is Resource.Loading -> {
                    _state.value = ApodDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}