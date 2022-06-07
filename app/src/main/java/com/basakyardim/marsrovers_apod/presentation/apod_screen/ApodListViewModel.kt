package com.basakyardim.marsrovers_apod.presentation.apod_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basakyardim.marsrovers_apod.common.Constants
import com.basakyardim.marsrovers_apod.common.Resource
import com.basakyardim.marsrovers_apod.domain.use_case.get_apods.GetApodsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.security.PrivateKey
import javax.inject.Inject

@HiltViewModel
class ApodListViewModel @Inject constructor(
    private val getApodsUseCase: GetApodsUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(ApodListState())
    val state: State<ApodListState> = _state

    init {
        getApods(start_date = "2022-05-04", api_key = Constants.API_KEY)
    }

    private fun getApods(start_date: String, api_key: String) {
        getApodsUseCase(start_date = start_date, api_key = api_key).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ApodListState(apods = result.data ?: emptyList())

                }
                is Resource.Error -> {
                    _state.value = ApodListState(
                        error = result.message ?: "An unexpected error occurred."
                    )

                }
                is Resource.Loading -> {
                    _state.value = ApodListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}