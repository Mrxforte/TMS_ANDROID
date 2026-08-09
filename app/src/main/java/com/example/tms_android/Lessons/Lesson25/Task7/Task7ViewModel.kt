package com.example.tms_android.Lessons.Lesson25.Task7

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

data class DataLoadState(
    val isLoading: Boolean = false,
    val data: String? = null,
    val error: String? = null
)

class Task7ViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DataLoadState())
    val uiState: StateFlow<DataLoadState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _uiState.value = DataLoadState(isLoading = true)
            delay(2000)
            
            val isSuccess = Random.nextBoolean()
            if (isSuccess) {
                _uiState.value = DataLoadState(isLoading = false, data = "Fetched Content: Flows are awesome!")
            } else {
                _uiState.value = DataLoadState(isLoading = false, error = "Oops! Something went wrong.")
            }
        }
    }
}
