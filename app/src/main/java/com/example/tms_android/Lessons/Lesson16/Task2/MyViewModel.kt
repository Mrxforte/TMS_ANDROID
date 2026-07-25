package com.example.tms_android.Lessons.Lesson16.Task2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val mutableStateFlow = MutableStateFlow<Boolean>(false)
    val flow = mutableStateFlow.asStateFlow()

    fun startLoading() {
        viewModelScope.launch {
            mutableStateFlow.emit(true)
            delay(6000)
            mutableStateFlow.emit(false)
        }
    }

}