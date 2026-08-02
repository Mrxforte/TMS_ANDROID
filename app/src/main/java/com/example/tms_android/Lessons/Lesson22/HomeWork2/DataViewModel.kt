package com.example.tms_android.Lessons.Lesson22.HomeWork2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class DataViewModel : ViewModel() {
    private val _state = MutableLiveData<DataState>(DataState.Idle)
    val state: LiveData<DataState> = _state

    fun loadData() {
        viewModelScope.launch {
            _state.value = DataState.Loading
            delay(2000) // Simulate network delay
            
            val isSuccess = Random.nextBoolean()
            if (isSuccess) {
                _state.value = DataState.Success("Data loaded successfully from server!")
            } else {
                _state.value = DataState.Error("Failed to load data. Please try again.")
            }
        }
    }

    fun resetToIdle() {
        _state.value = DataState.Idle
    }
}
