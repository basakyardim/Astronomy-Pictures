package com.basakyardim.astronomy_pictures.presentation.apod_list_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basakyardim.astronomy_pictures.domain.use_case.ApodListUseCase
import com.basakyardim.astronomy_pictures.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ApodListViewModel @Inject constructor(
    private val apodListUseCase: ApodListUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(ApodListState())
    val state: State<ApodListState> = _state

    init {
        val startDate = getStartDate()
        getApods(start_date = startDate)
    }

    private fun getApods(start_date: String) {
        apodListUseCase(start_date = start_date).onEach { result ->
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

    private fun getStartDate(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, -1)
        val date = calendar.time
        val format = SimpleDateFormat("yyyy-MM-dd")
        return format.format(date)
    }

}